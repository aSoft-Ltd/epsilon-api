@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE", "NOTHING_TO_INLINE")

package epsilon

import org.w3c.files.Blob as BBlob
import kase.Result

inline fun blobOf(blob: BBlob): Blob = BrowserBlob(blob)

inline fun blob(blob: BBlob? = null): Result<Blob> = Result(blob).map { blobOf(it) }