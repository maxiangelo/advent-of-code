package days.day2;

import days.Day;

import java.util.Arrays;

import static days.day2.HandPlay.*;

public class Day2 extends Day {
    public Day2(final String input) {
        super(input);
    }

    @Override
    protected Object evaluateFirst(final String input) {
        return Arrays.stream(input.split("\n"))
                .mapToInt(p -> {
                    final String[] split = p.split("\\s+");
                    return evaluateRound(split[0], split[1]);
                }).sum();
    }

    @Override
    protected Object evaluateSecond(final String input) {
        return Arrays.stream(input.split("\n"))
                .mapToInt(p -> {
                    final String[] split = p.split("\\s+");
                    return riggedEvaluate(split[0], split[1]);
                }).sum();
    }

    private Integer riggedEvaluate(final String enemy, final String order) {
        final HandPlay playByCode = getPlayByCode(enemy);

        return switch (order) {
            case "X" -> evaluateRound(playByCode, loose(playByCode));
            case "Y" -> evaluateRound(playByCode, playByCode);
            case "Z" -> evaluateRound(playByCode, win(playByCode));
            default -> 0;
        };
    }

    private HandPlay loose(final HandPlay enemy) {
        return switch (enemy) {
            case ROCK -> SCISSORS;
            case PAPER -> ROCK;
            case SCISSORS -> PAPER;
        };
    }

    private HandPlay win(final HandPlay enemy) {
        return switch (enemy) {
            case ROCK -> PAPER;
            case PAPER -> SCISSORS;
            case SCISSORS -> ROCK;
        };
    }

    private Integer evaluateRound(final String playerOne, final String playerTwo) {
        final HandPlay handPlayPlayerOne = HandPlay.getPlayByCode(playerOne);
        final HandPlay handPlayPlayerTwo = HandPlay.getPlayByCode(playerTwo);

        if (handPlayPlayerOne == handPlayPlayerTwo) {
            return 3 + handPlayPlayerTwo.getValue();
        }
        if ((handPlayPlayerOne.getValue() > handPlayPlayerTwo.getValue())) {
            if (!(handPlayPlayerOne == SCISSORS && handPlayPlayerTwo == ROCK)) {
                return handPlayPlayerTwo.getValue();
            }
        }

        if (handPlayPlayerOne == ROCK && handPlayPlayerTwo == SCISSORS) {
            return handPlayPlayerTwo.getValue();
        }

        return 6 + handPlayPlayerTwo.getValue();
    }

    private Integer evaluateRound(final HandPlay handPlayPlayerOne, final HandPlay handPlayPlayerTwo) {

        if (handPlayPlayerOne == handPlayPlayerTwo) {
            return 3 + handPlayPlayerTwo.getValue();
        }
        if ((handPlayPlayerOne.getValue() > handPlayPlayerTwo.getValue())) {
            if (!(handPlayPlayerOne == SCISSORS && handPlayPlayerTwo == ROCK)) {
                return handPlayPlayerTwo.getValue();
            }
        }

        if (handPlayPlayerOne == ROCK && handPlayPlayerTwo == SCISSORS) {
            return handPlayPlayerTwo.getValue();
        }

        return 6 + handPlayPlayerTwo.getValue();
    }
}
