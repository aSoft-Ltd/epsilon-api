package epsilon

import koncurrent.Executor
import koncurrent.Later

@Deprecated("In favour of RawFile")
class ByteArrayBlob(val value: ByteArray) : Blob {
    override fun readBytes(executor: Executor): Later<ByteArray> = Later(value, executor)
}