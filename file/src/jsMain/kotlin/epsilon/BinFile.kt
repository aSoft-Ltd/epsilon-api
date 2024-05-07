package epsilon

import org.w3c.files.File
import org.w3c.files.FilePropertyBag

actual fun BinFile(
    content: ByteArray,
    name: String,
    type: String
): RawFile = File(arrayOf(content), name, FilePropertyBag(type = type))