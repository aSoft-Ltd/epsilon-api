package epsilon.internal

import epsilon.RawFile
import epsilon.readBytesOf
import koncurrent.Executor
import koncurrent.Later
import org.w3c.files.FileReader
import epsilon.FileReader as MppFileReader

internal class BrowserFileReader : MppFileReader {

    val reader: FileReader = FileReader()

    override fun read(file: RawFile, executor: Executor): Later<ByteArray> = reader.readBytesOf(
        blob = file,
        executor = executor,
        actionName = "Reading ${file.name}",
        onAbortMessage = "File reading of ${file.name} has been aborted",
        onErrorMessage = "Failed to read file: ${file.name}"
    )
}