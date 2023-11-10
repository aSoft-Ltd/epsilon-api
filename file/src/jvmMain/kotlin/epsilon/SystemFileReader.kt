package epsilon

import epsilon.internal.JvmFileReader

actual fun SystemFileReader(): FileReader = JvmFileReader()