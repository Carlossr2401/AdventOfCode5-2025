package software.aoc.day05.b;

public class SolverFactory {
    public static Solver createSolver(String inputPath) {
        InstructionReader reader = ReaderFactory.createFileReader(inputPath);
        return new Day05BSolver(reader);
    }
}
