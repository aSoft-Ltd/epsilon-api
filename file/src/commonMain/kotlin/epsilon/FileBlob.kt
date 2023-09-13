@file:JsExport

package epsilon

import kollections.JsExport

interface FileBlob : Blob {
    val path: String
    val name: String
}