package software.aoc.day05.a;

public class SolverFactory {
    public static Solver createSolver(String inputPath) {
        InstructionReader reader = ReaderFactory.createFileReader(inputPath);
        return new Day05ASolver(reader);
    }
}
