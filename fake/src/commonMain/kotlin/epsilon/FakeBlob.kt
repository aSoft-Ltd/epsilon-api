package epsilon

import koncurrent.Executor
import koncurrent.Later

@Deprecated("In favour of RawFile")
class FakeBlob<out T>(val value: T) : Blob {
    override fun readBytes(executor: Executor): Later<ByteArray> = Later(
        value = value.toString().encodeToByteArray(), executor = executor
    )
}