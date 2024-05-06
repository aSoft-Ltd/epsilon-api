package epsilon

import org.w3c.files.File
import org.w3c.files.FilePropertyBag

actual fun TextFile(content: String, name: String): RawFile {
    return File(arrayOf(content), name, FilePropertyBag(type = "text/plain"))
}