package epsilon

import koncurrent.Executor
import koncurrent.Later
import koncurrent.PendingLater
import org.khronos.webgl.ArrayBuffer
import org.khronos.webgl.Int8Array
import org.khronos.webgl.get
import org.w3c.files.Blob
import org.w3c.files.FileReader

inline fun ArrayBuffer.toByteArray(): ByteArray {
    val array = Int8Array(this)
    return ByteArray(array.length) { array[it] }
}

fun FileReader.readBytesOf(
    blob: Blob,
    executor: Executor,
    actionName: String,
    onAbortMessage: String,
    onErrorMessage: String
): Later<ByteArray> {
    val later = PendingLater<ByteArray>(executor)
    val (reading) = later.setStages(actionName)
    onprogress = {
        later.updateProgress(reading(it.loaded.toLong(), it.total.toLong()))
    }
    onabort = {
        later.rejectWith(IllegalStateException(onAbortMessage))
    }
    onerror = {
        later.rejectWith(IllegalArgumentException(onErrorMessage))
    }
    onloadend = {
        val result = result.unsafeCast<ArrayBuffer>()
        later.resolveWith(result.toByteArray())
    }
    readAsArrayBuffer(blob)
    return later
}