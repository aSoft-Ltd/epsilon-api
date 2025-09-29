package epsilon

import koncurrent.Executor
import koncurrent.Later
import koncurrent.awaited.then
import koncurrent.awaited.andThen
import koncurrent.awaited.andZip
import koncurrent.awaited.zip
import koncurrent.awaited.catch
import koncurrent.awaited.then

@Deprecated("In favour of RawFile")
class FakeBlob<out T>(val value: T) : Blob {
    override fun readBytes(executor: Executor): Later<ByteArray> = Later(
        value = value.toString().encodeToByteArray(), executor = executor
    )
}