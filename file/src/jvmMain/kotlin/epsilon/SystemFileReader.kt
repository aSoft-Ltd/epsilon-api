package epsilon

import epsilon.internal.JvmFileReader
import kotlinx.coroutines.newFixedThreadPoolContext

actual fun SystemFileReader(): FileReader = JvmFileReader()