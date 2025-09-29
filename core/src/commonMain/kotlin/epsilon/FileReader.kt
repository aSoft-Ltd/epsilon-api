package epsilon

import koncurrent.Executor
import koncurrent.Executors
import koncurrent.Later
import koncurrent.awaited.then
import koncurrent.awaited.andThen
import koncurrent.awaited.andZip
import koncurrent.awaited.zip
import koncurrent.awaited.catch
import status.Progress

interface FileReader {
    fun read(file: RawFile, executor: Executor = Executors.default(), onProgress: ((Progress<MemorySize>) -> Unit)? = null): Later<ByteArray>
}