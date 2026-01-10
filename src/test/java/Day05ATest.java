import org.junit.Test;

import software.aoc.day05.Rank;
import software.aoc.day05.RankVerification;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class Day05ATest {

    @Test
    public void testInsideTheRank() {
        List<Rank> ranks = List.of(new Rank(10L, 20L));
        RankVerification rankVerification = new RankVerification(ranks);
        assertTrue(rankVerification.withinAnyRank(12L));
    }

    @Test
    public void testOutsideTheRank() {
        List<Rank> ranks = List.of(new Rank(10L, 20L));
        RankVerification rankVerification = new RankVerification(ranks);
        assertFalse(rankVerification.withinAnyRank(9L));
    }

    @Test
    public void testBoundaryStart() {
        List<Rank> ranks = List.of(new Rank(10L, 20L));
        RankVerification rankVerification = new RankVerification(ranks);
        assertTrue(rankVerification.withinAnyRank(10L));
    }

    @Test
    public void testBoundaryEnd() {
        List<Rank> ranks = List.of(new Rank(10L, 20L));
        RankVerification rankVerification = new RankVerification(ranks);
        assertTrue(rankVerification.withinAnyRank(20L));
    }

    @Test
    public void testMultipleRanksInsideSecond() {
        List<Rank> ranks = List.of(new Rank(1L, 5L), new Rank(10L, 20L));
        RankVerification rankVerification = new RankVerification(ranks);
        assertTrue(rankVerification.withinAnyRank(15L));
    }

    @Test
    public void testMultipleRanksOutsideAll() {
        List<Rank> ranks = List.of(new Rank(1L, 5L), new Rank(10L, 20L));
        RankVerification rankVerification = new RankVerification(ranks);
        assertFalse(rankVerification.withinAnyRank(7L));
    }

    @Test
    public void testOverlappingRanks() {
        List<Rank> ranks = List.of(new Rank(1L, 10L), new Rank(5L, 15L));
        RankVerification rankVerification = new RankVerification(ranks);
        assertTrue(rankVerification.withinAnyRank(7L));
    }

    @Test
    public void testSinglePointRange() {
        List<Rank> ranks = List.of(new Rank(5L, 5L));
        RankVerification rankVerification = new RankVerification(ranks);
        assertTrue(rankVerification.withinAnyRank(5L));
        assertFalse(rankVerification.withinAnyRank(4L));
    }

    @Test
    public void testEmptyRankList() {
        List<Rank> ranks = Collections.emptyList();
        RankVerification rankVerification = new RankVerification(ranks);
        assertFalse(rankVerification.withinAnyRank(10L));
    }

    @Test
    public void testLargeNumbers() {
        List<Rank> ranks = List.of(new Rank(1_000_000L, 2_000_000L));
        RankVerification rankVerification = new RankVerification(ranks);
        assertTrue(rankVerification.withinAnyRank(1_500_000L));
    }
}