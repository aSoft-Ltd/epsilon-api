package epsilon

import koncurrent.Executor
import koncurrent.Later
import koncurrent.later.then
import koncurrent.toLater
import java.awt.Desktop
import java.io.File

internal class JvmFileManager(
    private val tmp: String = System.getProperty("java.io.tmpdir") ?: "/tmp",
    private val download: String = (System.getenv("HOME") ?: "/tmp") + "/Downloads"
) : FileManager {
    override val create by lazy { JvmFileCreator(tmp) }

    override fun open(url: String): Later<String> = url.toLater().then {
        Desktop.getDesktop().open(File(url))
        it
    }

    override fun save(url: String, name: String?): Later<String> = url.toLater().then {
        val dst = File(download, name ?: it.substringAfterLast("/"))
        File(it).renameTo(dst)
        dst
    }.then { it.absolutePath }

    override fun read(file: RawFile, executor: Executor): Later<ByteArray> = Later(executor) { resolve, reject ->
        try {
            resolve(file.readBytes())
        } catch (err: Throwable) {
            reject(err)
        }
    }
}