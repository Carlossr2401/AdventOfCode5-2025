package software.aoc.day05;

public record Rank(Long start, Long end) {

    public Long startValue() {
        return start;
    }

    public Long endValue() {
        return end;
    }

    public boolean withinTheRange(Long value) {
        return value <= end && value >= start;
    }
}
