package epsilon

expect fun TextFile(
    content: String = "test content",
    name: String = "test.txt",
    type: String = "text/plain"
): RawFile