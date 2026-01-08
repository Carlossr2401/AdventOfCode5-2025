package software.aoc.day05.b;

public class ReaderFactory {
    public static InstructionReader createFileReader(String path) {
        return new FileInstructionReader(path);
    }
}
