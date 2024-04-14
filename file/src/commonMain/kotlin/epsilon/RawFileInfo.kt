package epsilon

import koncurrent.Later
import epsilon.RawFile

expect class RawFileInfo(file: RawFile) {
    val file: RawFile
    @Deprecated("use nameWithExtension or nameWithoutExtension")
    val name: String
    val nameWithExtension: String
    val nameWithoutExtension: String
    val extension: String
    fun path(): Later<String>
}