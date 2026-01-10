package software.aoc.day05.a;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

import software.aoc.day05.FileOutput;
import software.aoc.day05.InstructionReader;
import software.aoc.day05.RankVerification;
import software.aoc.day05.Solver;

public class Day05ASolver implements Solver {
    private final InstructionReader reader;

    public Day05ASolver(InstructionReader reader) {
        this.reader = reader;
    }

    @Override
    public Object solve() throws IOException {
        FileOutput data = reader.readAllData();

        RankVerification rankVerification = new RankVerification(data.ranges());
        AtomicInteger validIds = new AtomicInteger();

        data.id().forEach(id -> {
            if (rankVerification.withinAnyRank(id)) validIds.getAndIncrement();
        });

        return validIds.get();
    }
}
