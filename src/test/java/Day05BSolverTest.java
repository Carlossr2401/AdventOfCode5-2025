import org.junit.Test;
import software.aoc.day05.b.*;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day05BSolverTest {

    // Stub manual para la Parte B
    static class StubInstructionReader implements InstructionReader {
        private final FileOutput dataToReturn;

        public StubInstructionReader(FileOutput dataToReturn) {
            this.dataToReturn = dataToReturn;
        }

        @Override
        public FileOutput readAllData() throws IOException {
            return dataToReturn;
        }
    }

    @Test
    public void testSolve_OverlappingRanges_ShouldMergeAndCountTotal() throws IOException {
        // ARRANGE
        // Simulamos rangos que se solapan: [1, 5] y [4, 8].
        // La unión es [1, 8], cantidad total de frescos = 8
        List<Rank> ranks = List.of(
            new Rank(1L, 5L),
            new Rank(4L, 8L)
        );
        // En la parte B, los IDs individuales en la lista se ignoran para el cálculo final,
        // pero FileOutput los requiere en el constructor. Pasamos una lista vacía o irrelevante.
        List<Long> ignoredIds = List.of(1L, 2L, 3L); 
        FileOutput stubData = new FileOutput(ranks, ignoredIds);

        InstructionReader stubReader = new StubInstructionReader(stubData);
        Solver solver = new Day05BSolver(stubReader);

        // ACT
        Object result = solver.solve();

        // ASSERT
        assertEquals(8L, result);
    }

    @Test
    public void testSolve_DisjointRanges_ShouldSumDistinctCounts() throws IOException {
        // ARRANGE
        // Rangos disjuntos: [1, 2] (2 items) y [5, 5] (1 item)
        // Total = 3
        List<Rank> ranks = List.of(
            new Rank(1L, 2L),
            new Rank(5L, 5L)
        );
        List<Long> ignoredIds = List.of();
        FileOutput stubData = new FileOutput(ranks, ignoredIds);

        InstructionReader stubReader = new StubInstructionReader(stubData);
        Solver solver = new Day05BSolver(stubReader);

        // ACT
        Object result = solver.solve();

        // ASSERT
        assertEquals(3L, result);
    }
}
