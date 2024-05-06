package epsilon

import java.io.File

actual fun TextFile(content: String, name: String): RawFile {
    val tmp = System.getProperty("java.io.tmpdir") ?: "/tmp"
    return File(tmp, name).apply {
        createNewFile()
        writeText(content)
    }
}