package software.aoc.day05.b;

public record Rank(Long start, Long end) {

    public boolean withinTheRange(Long value) {
        return value <= end && value >= start;
    }


}
