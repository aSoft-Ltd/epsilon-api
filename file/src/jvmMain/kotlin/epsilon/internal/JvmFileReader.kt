package epsilon.internal

import epsilon.FileReader
import epsilon.RawFile
import epsilon.RawFileInfo
import koncurrent.Executor
import koncurrent.Later
import koncurrent.SynchronousExecutor
import koncurrent.later.then
import koncurrent.later.andThen
import koncurrent.later.andZip
import koncurrent.later.zip
import koncurrent.later.catch
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