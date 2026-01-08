package software.aoc.day05.b;

import java.io.IOException;

public class Day05BSolver implements Solver {
    private final InstructionReader reader;

    public Day05BSolver(InstructionReader reader) {
        this.reader = reader;
    }

    @Override
    public Object solve() throws IOException {
        FileOutput data = reader.readAllData();
        RankVerification rankVerification = new RankVerification(data.ranges());
        return rankVerification.calculateTotalFreshIds();
    }
}
