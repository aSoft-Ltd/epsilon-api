package epsilon

actual fun SystemFileReader(): FileReader = JvmFileManager()