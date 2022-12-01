package days;

import java.util.Arrays;
import java.util.Collections;

public class Day1 extends Day {
    public Day1(final String input) {
        super(input);
    }

    @Override
    protected Object evaluateFirst(final String input) {
        return Arrays.stream(input.split("\n\n"))
                .mapToInt(innerList ->
                        Arrays.stream(innerList.split("\n"))
                                .mapToInt(Integer::parseInt)
                                .sum()
                ).max().getAsInt();
    }

    @Override
    protected Object evaluateSecond(final String input) {
        return Arrays.stream(input.split("\n\n"))
                .mapToInt(innerList ->
                        Arrays.stream(innerList.split("\n"))
                                .mapToInt(Integer::parseInt)
                                .sum()
                )
                .boxed()
                .sorted(Collections.reverseOrder())
                .limit(3)
                .reduce(0, Integer::sum);
    }
}
