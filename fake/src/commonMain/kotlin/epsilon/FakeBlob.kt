package epsilon

import koncurrent.Executor
import koncurrent.Later
import koncurrent.later.then
import koncurrent.later.andThen
import koncurrent.later.andZip
import koncurrent.later.zip
import koncurrent.later.catch
import koncurrent.later.then

@Deprecated("In favour of RawFile")
class FakeBlob<out T>(val value: T) : Blob {
    override fun readBytes(executor: Executor): Later<ByteArray> = Later(
        value = value.toString().encodeToByteArray(), executor = executor
    )
}