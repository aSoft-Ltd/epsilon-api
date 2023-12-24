package epsilon

import koncurrent.Later
import koncurrent.later.then
import koncurrent.later.andThen
import koncurrent.later.andZip
import koncurrent.later.zip
import koncurrent.later.catch
actual class RawFileInfo actual constructor(actual val file: RawFile) {
    @Deprecated("in favour of nameWithExtension or nameWithoutExtension")
    actual val name : String get() = throw Throwable("Not implemented")

    actual val nameWithoutExtension: String get() = throw Throwable("Not implemented")

    actual val nameWithExtension: String get() = throw Throwable("Not implemented")

    actual val extension: String get() = throw Throwable("Not implemented")
    actual fun path() : Later<String> = throw Throwable("Not implemented")
}