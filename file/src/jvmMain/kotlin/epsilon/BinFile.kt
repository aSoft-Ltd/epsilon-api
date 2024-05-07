package epsilon

import java.io.File

actual fun BinFile(
    content: ByteArray,
    name: String,
    type: String
): RawFile {
    val tmp = System.getProperty("java.io.tmpdir") ?: "/tmp"
    return File(tmp, name).apply {
        createNewFile()
        writeBytes(content)
    }
}