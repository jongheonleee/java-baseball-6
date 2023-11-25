package baseball.model;

import java.util.Objects;

public class Ball {

    private static final Integer MIN_NUMBER = 1;
    private static final Integer MAX_NUMBER = 9;
    private final Integer ball;


    public Ball(Integer ball) {
        validate(ball);
        this.ball = ball;
    }

    private void validate(Integer ball) {
        if (!isIncludedInRangeNumber(ball)) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력값입니다.");
        }
    }

    private Boolean isIncludedInRangeNumber(Integer ball) {
        return (MIN_NUMBER <= ball && ball <= MAX_NUMBER);
    }

    // 메시지 : ComputerBalls의 선정된 숫자 넘김 -> 같은 숫자인지 비교
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
