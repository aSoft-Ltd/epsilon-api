package epsilon

import org.w3c.files.File
import org.w3c.files.FilePropertyBag

internal class BrowserFileCreator : FileCreator {

    override fun binary(
        content: ByteArray,
        name: String,
        type: String
    ): RawFile = File(arrayOf(content), name, FilePropertyBag(type = type))

    override fun text(
        content: String,
        name: String,
        type: String
    ): RawFile = File(arrayOf(content), name, FilePropertyBag(type = type))
}