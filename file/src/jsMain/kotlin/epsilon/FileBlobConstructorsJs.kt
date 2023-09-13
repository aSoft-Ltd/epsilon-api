@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE", "NOTHING_TO_INLINE")

package epsilon

import epsilon.internal.FileBlobImpl
import kase.Result
import kollections.List
import kollections.iEmptyList
import kollections.toIList
import org.w3c.dom.asList
import org.w3c.files.File
import org.w3c.files.FileList

inline fun fileBlobsFrom(list: FileList?): List<FileBlob> = list?.asList()?.map { fileBlobOf(it) }?.toIList() ?: iEmptyList()

inline fun fileBlobOf(file: File): FileBlob = FileBlobImpl(file)

inline fun fileBlob(file: File? = null): Result<FileBlob> = Result(file).map { fileBlobOf(it) }