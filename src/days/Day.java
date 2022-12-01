package days;

public abstract class Day {

    private final String input;

    public Day(final String input) {
        this.input = input;
    }

    public void evaluate(){
        System.out.println("first: " + evaluateFirst(input));
        System.out.println("second: " + evaluateSecond(input));
    }

    protected abstract Object evaluateFirst(final String input);
    protected abstract Object evaluateSecond(final String input);
}
