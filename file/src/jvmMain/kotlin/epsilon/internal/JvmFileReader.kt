package epsilon.internal

import epsilon.FileReader
import epsilon.RawFile
import epsilon.RawFileInfo
import koncurrent.Executor
import koncurrent.Later
import koncurrent.SynchronousExecutor
import koncurrent.awaited.then
import koncurrent.awaited.andThen
import koncurrent.awaited.andZip
import koncurrent.awaited.zip
import koncurrent.awaited.catch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.newSingleThreadContext
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

internal class JvmFileReader : FileReader {
    override fun read(file: RawFile, executor: Executor): Later<ByteArray> = Later(executor) { resolve, reject ->
        try {
            resolve(file.readBytes())
        } catch (err: Throwable) {
            reject(err)
        }
    }
}