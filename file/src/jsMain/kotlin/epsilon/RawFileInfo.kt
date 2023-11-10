@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package epsilon

import epsilon.internal.BrowserFileReader
import koncurrent.SetTimeoutExecutor

actual class RawFileInfo actual constructor(actual val file: RawFile) {
    actual val name = file.name

    actual fun path() = BrowserFileReader.native.readBase64Url(
        blob = file,
        executor = SetTimeoutExecutor,
        actionName = "constructing url for ${file.name}",
        onAbortMessage = "File reading of ${file.name} has been aborted",
        onErrorMessage = "Failed to read file: ${file.name}"
    )
}