package epsilon

import koncurrent.Later

actual class RawFileInfo actual constructor(actual val file: RawFile) {
    actual val name by lazy { file.name }
    actual fun path() = Later(file.absolutePath)
}