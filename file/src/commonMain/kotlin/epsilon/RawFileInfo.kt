package epsilon

import koncurrent.Later

expect class RawFileInfo(file: RawFile) {
    val file: RawFile
    val name: String
    fun path(): Later<String>
}