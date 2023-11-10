@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package epsilon

import koncurrent.Executor
import koncurrent.Executors
import koncurrent.Later
import kotlin.js.JsExport

@Deprecated("In favour of RawFile")
interface Blob {
    fun readBytes(executor: Executor = Executors.default()): Later<ByteArray>
}
