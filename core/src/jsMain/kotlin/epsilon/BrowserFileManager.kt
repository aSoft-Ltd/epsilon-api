package epsilon

import koncurrent.Executor
import koncurrent.Later
import koncurrent.later.then
import koncurrent.toLater
import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.HTMLAnchorElement
import org.w3c.files.FileReader

class BrowserFileManager : FileManager {

    override val create : FileCreator by lazy { BrowserFileCreator() }

    override fun open(url: String): Later<String> = window.open(url, "_blank").toLater().then { url }

    override fun save(url: String, name: String?): Later<String> {
        val filename = name ?: "file"
        return Later(url).then {
            val a = document.createElement("a") as HTMLAnchorElement
            a.href = url
            a.target = "_blank"
            a.download = filename
            document.body?.appendChild(a)
            a
        }.then {
            it.click()
            document.body?.removeChild(it)
            url
        }
    }


    private val reader: FileReader = FileReader()
    override fun read(file: RawFile, executor: Executor): Later<ByteArray> = reader.readBytesOf(
        blob = file,
        executor = executor,
        actionName = "Reading ${file.name}",
        onAbortMessage = "File reading of ${file.name} has been aborted",
        onErrorMessage = "Failed to read file: ${file.name}"
    )
}