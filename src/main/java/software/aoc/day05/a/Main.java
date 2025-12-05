package software.aoc.day05.a;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    static void main() throws IOException {
        FileInstructionReader reader = new FileInstructionReader("src/main/resources/input");

        FileOutput data = reader.readAllData();

        RankVerification rankVerification = new RankVerification(data.ranges());
        AtomicInteger validIds = new AtomicInteger();

        data.id().forEach(id -> {
            if (rankVerification.withinAnyRank(id)) validIds.getAndIncrement();
        });

        System.out.println(validIds.get());
    }
}
