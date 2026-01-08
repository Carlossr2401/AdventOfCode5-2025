package software.aoc.day05.b;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public record FileInstructionReader(String filePath) implements InstructionReader {

    public FileOutput readAllData() throws IOException {

        List<Rank> allRanges = new ArrayList<>();
        List<Long> allIds = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            boolean readingRanges = true;

            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    readingRanges = false;
                    continue;
                }

                if (readingRanges) {
                    String[] range = line.split("-");
                    allRanges.add(new Rank(Long.parseLong(range[0]), Long.parseLong(range[1])));
                } else {
                    allIds.add(Long.parseLong(line));
                }
            }
        }

        return new FileOutput(allRanges, allIds);
    }
}