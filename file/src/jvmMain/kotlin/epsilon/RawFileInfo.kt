package epsilon

import koncurrent.Later

actual class RawFileInfo actual constructor(actual val file: RawFile) {
    @Deprecated("in favour of nameWithExtension or nameWithoutExtension")
    actual val name by lazy { file.name }

    actual val nameWithoutExtension by lazy { file.nameWithoutExtension }

    actual val nameWithExtension by lazy { file.name }

    actual val extension by lazy { file.extension }
    actual fun path() = Later(file.absolutePath)
}