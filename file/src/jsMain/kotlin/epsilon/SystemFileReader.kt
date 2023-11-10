package epsilon

import epsilon.internal.BrowserFileReader

actual fun SystemFileReader(): FileReader = BrowserFileReader()