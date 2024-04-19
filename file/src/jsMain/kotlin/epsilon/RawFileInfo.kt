@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package epsilon

import epsilon.internal.BrowserFileReader
import koncurrent.Executors
import koncurrent.Later

actual class RawFileInfo actual constructor(actual val file: RawFile) {
    @Deprecated("in favour of nameWithExtension or nameWithoutExtension")
    actual val name = file.name

    actual val nameWithExtension by lazy { file.name }

    actual val nameWithoutExtension by lazy { file.name.substringBeforeLast(".") }

    actual val extension by lazy { file.name.substringAfterLast(".") }

    actual fun path() = paths.getOrPut(file) {
        BrowserFileReader().reader.readDataUrl(
            blob = file,
            executor = Executors.default(),
            actionName = "constructing url for ${file.name}",
            onAbortMessage = "File reading of ${file.name} has been aborted",
            onErrorMessage = "Failed to read file: ${file.name}"
        )
    }

    private companion object {
        val paths = mutableMapOf<RawFile, Later<String>>()
    }
}