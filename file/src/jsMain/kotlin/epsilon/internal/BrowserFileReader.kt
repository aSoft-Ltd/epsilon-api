package epsilon.internal

import epsilon.RawFile
import epsilon.readBytesOf
import koncurrent.Executor
import koncurrent.Later
import org.w3c.files.FileReader
import epsilon.FileReader as MppFileReader

internal class BrowserFileReader : MppFileReader {

    override fun read(file: RawFile, executor: Executor): Later<ByteArray> = native.readBytesOf(
        blob = file,
        executor = executor,
        actionName = "Reading ${file.name}",
        onAbortMessage = "File reading of ${file.name} has been aborted",
        onErrorMessage = "Failed to read file: ${file.name}"
    )

    companion object {
        val native by lazy { FileReader() }
    }
}