package software.aoc.day05.a;

import java.util.List;

public record RankVerification(List<Rank> ranges) {

    public boolean withinAnyRank(Long value) {
        for (Rank r : ranges) {
            if (r.withinTheRange(value)) return true;
        }
        return false;
    }
}
