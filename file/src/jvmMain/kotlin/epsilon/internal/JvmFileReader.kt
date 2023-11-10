package epsilon.internal

import epsilon.FileReader
import epsilon.RawFile
import epsilon.RawFileInfo
import koncurrent.Executor
import koncurrent.Later

internal class JvmFileReader : FileReader {
    override fun read(file: RawFile, executor: Executor): Later<ByteArray> = Later(executor) { resolve, reject ->
        try {
            resolve(file.readBytes())
        } catch (err: Throwable) {
            reject(err)
        }
    }
}