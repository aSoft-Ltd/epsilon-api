@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package epsilon

import koncurrent.Executor
import koncurrent.Executors
import koncurrent.Later
import koncurrent.later.then
import koncurrent.later.andThen
import koncurrent.later.andZip
import koncurrent.later.zip
import koncurrent.later.catch
import kotlinx.JsExport

@Deprecated("In favour of RawFile")
interface Blob {
    fun readBytes(executor: Executor = Executors.default()): Later<ByteArray>
}
