package epsilon

import koncurrent.Later
import koncurrent.later.then
import koncurrent.later.andThen
import koncurrent.later.andZip
import koncurrent.later.zip
import koncurrent.later.catch

expect class RawFileInfo(file: RawFile) {
    val file: RawFile
    @Deprecated("use nameWithExtension or nameWithoutExtension")
    val name: String
    val nameWithExtension: String
    val nameWithoutExtension: String
    val extension: String
    fun path(): Later<String>
}