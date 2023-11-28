package baseball.model;

import static baseball.constant.BallConstant.MAX_NUMBER;
import static baseball.constant.BallConstant.MIN_NUMBER;
import static baseball.exception.BallExceptionMessage.*;

import baseball.exception.BallExceptionMessage;
import java.util.Objects;

public class Ball {

    private final Integer ball;

    public Ball(Integer ball) {
        validate(ball);
        this.ball = ball;
    }

    private void validate(Integer ball) {
        if (!isIncludedInRangeNumber(ball)) {
            throw new IllegalArgumentException(WRONG_RANGE_NUMBER.getMessage());
        }
    }

    private Boolean isIncludedInRangeNumber(Integer ball) {
        return (MIN_NUMBER.getSetting() <= ball && ball <= MAX_NUMBER.getSetting());
    }

    public Boolean isSameBall(Integer ball) {
        return this.ball == ball;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null || getClass() != that.getClass()) {
            return false;
        }
        Ball thatBall = (Ball) that;
        return Objects.equals(ball, thatBall.ball);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ball);
    }
}
