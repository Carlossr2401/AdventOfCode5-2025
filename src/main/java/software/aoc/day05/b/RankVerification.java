package software.aoc.day05.b;

import java.util.*;

public record RankVerification(List<Rank> ranges) {

    public boolean withinAnyRank(Long value) {
        for (Rank r : ranges) {
            if (r.withinTheRange(value)) return true;
        }
        return false;
    }

    public List<Rank> mergeRanges() {
        if (this.ranges.isEmpty()) return Collections.emptyList();

        List<Rank> sortedRanges = new ArrayList<>(this.ranges);
        sortedRanges.sort(Comparator.comparing(Rank::start));

        List<Rank> mergedRanges = new ArrayList<>();
        Rank actual = sortedRanges.get(0);

        for (int i = 1; i < sortedRanges.size(); i++) {
            Rank siguiente = sortedRanges.get(i);

            if (siguiente.start() <= actual.end() + 1) {
                long nuevoFin = Math.max(actual.end(), siguiente.end());
                actual = new Rank(actual.start(), nuevoFin);
            } else {
                mergedRanges.add(actual);
                actual = siguiente;
            }
        }

        mergedRanges.add(actual);
        return mergedRanges;
    }

    public long calculateTotalFreshIds() {
        List<Rank> mergedRanges = mergeRanges();

        long totalIDs = 0;
        for (Rank rango : mergedRanges) {
            totalIDs += (rango.end() - rango.start() + 1);
        }

        return totalIDs;
    }
}