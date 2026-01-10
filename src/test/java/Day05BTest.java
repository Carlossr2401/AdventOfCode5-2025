import org.junit.Test;

import software.aoc.day05.RankVerification;
import software.aoc.day05.Rank;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class Day05BTest {

    @Test
    public void testSingleRangeTotal() {
        List<Rank> ranks = List.of(new Rank(1L, 5L));
        RankVerification rv = new RankVerification(ranks);
        // 1,2,3,4,5 -> 5 IDs
        assertEquals(5L, rv.calculateTotalFreshIds());
    }

    @Test
    public void testNonOverlappingRanges() {
        List<Rank> ranks = List.of(new Rank(1L, 5L), new Rank(10L, 12L));
        RankVerification rv = new RankVerification(ranks);
        // 1-5 (5) + 10-12 (3) = 8
        assertEquals(8L, rv.calculateTotalFreshIds());
    }

    @Test
    public void testOverlappingRanges() {
        List<Rank> ranks = List.of(new Rank(1L, 5L), new Rank(3L, 7L));
        RankVerification rv = new RankVerification(ranks);
        // Merged: 1-7 -> 7 IDs
        assertEquals(7L, rv.calculateTotalFreshIds());
    }

    @Test
    public void testContainedRange() {
        List<Rank> ranks = List.of(new Rank(1L, 10L), new Rank(3L, 5L));
        RankVerification rv = new RankVerification(ranks);
        // Merged: 1-10 -> 10 IDs
        assertEquals(10L, rv.calculateTotalFreshIds());
    }

    @Test
    public void testAdjacentRangesMerge() {
        List<Rank> ranks = List.of(new Rank(1L, 5L), new Rank(6L, 10L));
        RankVerification rv = new RankVerification(ranks);
        // 1-5 and 6-10 merge to 1-10 -> 10 IDs
        assertEquals(10L, rv.calculateTotalFreshIds());
    }

    @Test
    public void testGapRanges() {
        List<Rank> ranks = List.of(new Rank(1L, 5L), new Rank(7L, 10L));
        RankVerification rv = new RankVerification(ranks);
        // 1-5 (5) and 7-10 (4) -> 9 IDs (6 is missing)
        assertEquals(9L, rv.calculateTotalFreshIds());
    }

    @Test
    public void testUnorderedInput() {
        List<Rank> ranks = Arrays.asList(new Rank(10L, 15L), new Rank(1L, 5L));
        RankVerification rv = new RankVerification(ranks);
        // Should process as 1-5 (5) and 10-15 (6) -> 11
        assertEquals(11L, rv.calculateTotalFreshIds());
    }

    @Test
    public void testMultipleOverlaps() {
        List<Rank> ranks = List.of(
            new Rank(1L, 5L),
            new Rank(2L, 6L),
            new Rank(8L, 10L)
        );
        RankVerification rv = new RankVerification(ranks);
        // 1-5 + 2-6 -> 1-6 (6 IDs)
        // 8-10 (3 IDs)
        // Total 9
        assertEquals(9L, rv.calculateTotalFreshIds());
    }

    @Test
    public void testSinglePointRange() {
        List<Rank> ranks = List.of(new Rank(5L, 5L));
        RankVerification rv = new RankVerification(ranks);
        // 5-5 -> 1 ID
        assertEquals(1L, rv.calculateTotalFreshIds());
    }

    @Test
    public void testEmptyList() {
        List<Rank> ranks = Collections.emptyList();
        RankVerification rv = new RankVerification(ranks);
        assertEquals(0L, rv.calculateTotalFreshIds());
    }
}
