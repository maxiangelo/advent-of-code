package days.day4;

import days.Day;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Day4 extends Day {
    public Day4(final String input) {
        super(input);
    }

    @Override
    protected Object evaluateFirst(final String input) {
        return Arrays.stream(input.split("\n"))
                .map(s -> {
                    final List<Range> ranges = Arrays.stream(s.split(","))
                            .map(r -> {
                                final int[] ints = Arrays.stream(r.split("-"))
                                        .mapToInt(Integer::parseInt)
                                        .toArray();

                                return new Range(ints[0], ints[1]);
                            })
                            .toList();

                    return containsOther(ranges.get(0), ranges.get(1));
                })
                .filter(Boolean::booleanValue)
                .count();
    }

    @Override
    protected Object evaluateSecond(final String input) {
        return Arrays.stream(input.split("\n"))
                .map(s -> {
                    final List<Range> ranges = Arrays.stream(s.split(","))
                            .map(r -> {
                                final int[] ints = Arrays.stream(r.split("-"))
                                        .mapToInt(Integer::parseInt)
                                        .toArray();

                                return new Range(ints[0], ints[1]);
                            })
                            .toList();

                    return overlapsOther(ranges.get(0), ranges.get(1));
                })
                .filter(Boolean::booleanValue)
                .count();
    }

    private static boolean overlapsOther(final Range one, final Range two) {
        return one.start() <= two.end() && two.start() <= one.end();
    }

    private static boolean containsOther(final Range one, final Range two) {
        return one.start() <= two.start() && one.end() >= two.end() || one.start() >= two.start() && one.end() <=
                two.end();
    }
}
