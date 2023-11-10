package epsilon

actual class RawFileInfo actual constructor(actual val file: RawFile) {
    actual val name : String get() = throw Throwable("Not implemented")
    actual val path : String get() = throw Throwable("Not implemented")
}