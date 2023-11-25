package baseball.model;

import java.util.ArrayList;
import java.util.Arrays;

public enum PlayerResult {

    THREE_STRIKE(3, 0, "3스트라이크"),
    TWO_STRIKE(2, 0, "2스트라이크"),
    TWO_STRIKE_ONE_BALL(2, 1, "2스트라이크 1볼"),
    ONE_STRIKE(1, 0, "1스트라이크"),
    ONE_STRIKE_ONE_BALL(1, 1, "1스트라이크 1볼"),
    ONE_STRIKE_TWO_BALL(1, 2, "1스트라이크 2볼"),
    ONE_BALL(0, 1, "1볼"),
    TWO_BALL(0, 2, "2볼"),
    THREE_BALL(0, 3, "3볼"),
    NOTHING(0, 0, "낫싱");

    private final Integer strike;
    private final Integer ball;
    private final String message;

    PlayerResult(Integer strike, Integer ball, String message) {
        this.strike = strike;
        this.ball = ball;
        this.message = message;
    }

    public static PlayerResult of(Integer strike, Integer ball) {
        return Arrays.stream(PlayerResult.values())
                .filter(result -> result.strike == strike && result.ball == ball)
                .findFirst()
                .orElse(NOTHING);
    }

    public String getMessage() {
        return this.message;
    }
}