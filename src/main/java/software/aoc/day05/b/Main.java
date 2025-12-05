package software.aoc.day05.b;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    static void main() throws IOException {
        FileInstructionReader reader = new FileInstructionReader("src/main/resources/input");

        FileOutput data = reader.readAllData();

        RankVerification rankVerification = new RankVerification(data.ranges());

        System.out.println(rankVerification.calculateTotalFreshIds());
    }
}
