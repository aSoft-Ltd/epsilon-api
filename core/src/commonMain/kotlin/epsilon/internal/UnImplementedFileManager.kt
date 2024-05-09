package epsilon.internal

import epsilon.FileManager
import epsilon.RawFile
import koncurrent.Executor
import koncurrent.Later
import koncurrent.TODOLater

internal class UnImplementedFileManager : FileManager {

    override val create by lazy { UnImplementedFileCreator() }

    override fun download(url: String, name: String?, headers: Map<String, String>): Later<RawFile> = TODOLater()

    override fun open(url: String): Later<String> = TODOLater()

    override fun save(url: String, name: String?): Later<String> = TODOLater()

    override fun read(file: RawFile, executor: Executor): Later<ByteArray>  = TODOLater()
}