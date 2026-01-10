import org.junit.Test;

import software.aoc.day05.FileOutput;
import software.aoc.day05.InstructionReader;
import software.aoc.day05.Rank;
import software.aoc.day05.Solver;
import software.aoc.day05.a.Day05ASolver;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day05ASolverTest {

    // 1. Definimos un Stub manual para simular el comportamiento de InstructionReader
    // Esto es "Test Double" en terminología TDD puros.
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
    public void testSolve_WithMixedIds_ShouldCountInsideRanksOnly() throws IOException {
        // ARRANGE (Dado...)
        // Simulamos unos datos de entrada: Un rango [10, 20] y tres IDs: 5 (fuera), 15 (dentro), 25 (fuera)
        List<Rank> ranks = List.of(new Rank(10L, 20L));
        List<Long> ids = List.of(5L, 15L, 25L);
        FileOutput stubData = new FileOutput(ranks, ids);

        // Inyectamos el Stub en el Solver (Principio DIP en acción)
        InstructionReader stubReader = new StubInstructionReader(stubData);
        Solver solver = new Day05ASolver(stubReader);

        // ACT (Cuando...)
        Object result = solver.solve();

        // ASSERT (Entonces...)
        // Esperamos que el resultado sea 1 (solo el ID 15 es válido)
        assertEquals(1, result);
    }

    @Test
    public void testSolve_AllOutside_ShouldReturnZero() throws IOException {
        // ARRANGE
        List<Rank> ranks = List.of(new Rank(10L, 20L));
        List<Long> ids = List.of(1L, 2L, 30L); // Todos fuera
        FileOutput stubData = new FileOutput(ranks, ids);

        InstructionReader stubReader = new StubInstructionReader(stubData);
        Solver solver = new Day05ASolver(stubReader);

        // ACT
        Object result = solver.solve();

        // ASSERT
        assertEquals(0, result);
    }
}
