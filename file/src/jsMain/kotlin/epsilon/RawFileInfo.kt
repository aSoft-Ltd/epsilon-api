@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package epsilon

import epsilon.internal.BrowserFileReader
import koncurrent.SetTimeoutExecutor

actual class RawFileInfo actual constructor(actual val file: RawFile) {
    @Deprecated("in favour of nameWithExtension or nameWithoutExtension")
    actual val name = file.name

    actual val nameWithExtension by lazy { file.name }

    actual val nameWithoutExtension by lazy { file.name.substringBeforeLast(".") }

    actual val extension by lazy { file.name.substringAfterLast(".") }

    actual fun path() = BrowserFileReader.native.readBase64Url(
        blob = file,
        executor = SetTimeoutExecutor,
        actionName = "constructing url for ${file.name}",
        onAbortMessage = "File reading of ${file.name} has been aborted",
        onErrorMessage = "Failed to read file: ${file.name}"
    )
}