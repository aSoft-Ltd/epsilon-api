package epsilon

import org.w3c.files.File
import org.w3c.files.FilePropertyBag

actual fun TextFile(
    content: String,
    name: String,
    type: String
): RawFile = File(arrayOf(content), name, FilePropertyBag(type = type))