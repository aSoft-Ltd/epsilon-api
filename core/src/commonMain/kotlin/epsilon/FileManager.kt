package epsilon

interface FileManager : FileOpener, FileSaver, FileReader {
    val create: FileCreator
}