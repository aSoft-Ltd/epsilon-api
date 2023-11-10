package epsilon

import koncurrent.Executor
import koncurrent.Executors
import koncurrent.Later

interface FileReader {
    fun read(file: RawFile, executor: Executor = Executors.default()): Later<ByteArray>
}