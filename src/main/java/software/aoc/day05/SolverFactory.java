package software.aoc.day05;

import software.aoc.day05.a.Day05ASolver;
import software.aoc.day05.b.Day05BSolver;

public class SolverFactory {

    public static Solver createSolver(String type, String inputPath) {
        return switch (type) {
            case "A" -> new Day05ASolver(new FileInstructionReader(inputPath));
            case "B" -> new Day05BSolver(new FileInstructionReader(inputPath));
            default -> throw new IllegalArgumentException("Invalid solver type: " + type);
        };
    }
}
