import org.junit.Test;
import software.aoc.day05.a.Rank;
import software.aoc.day05.a.RankVerification;

import java.util.List;

import static org.junit.Assert.*;

public class Day05ATest {

    @Test
    public void testInsideTheRank() {
        List<Rank> ranks = List.of(new Rank(10L, 20L));
        RankVerification rankVerification = new RankVerification(ranks);

        assertEquals(true, rankVerification.withinAnyRank(12L));
    }

    @Test
    public void testOutsideTheRank() {
        List<Rank> ranks = List.of(new Rank(10L, 20L));
        RankVerification rankVerification = new RankVerification(ranks);

        assertEquals(false, rankVerification.withinAnyRank(9L));
    }
}