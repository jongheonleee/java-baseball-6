package baseball.model;

import static baseball.constant.BallConstant.MAX_NUMBER;
import static baseball.constant.BallConstant.MIN_NUMBER;
import static baseball.constant.ComputerBallsConstant.LENGTH;
import static baseball.exception.ComputerBallsExceptionMessage.*;

import baseball.exception.ComputerBallsExceptionMessage;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ComputerBalls {

    private final List<Integer> balls;

    public ComputerBalls(List<Integer> balls) {
        validate(balls);
        this.balls = balls;
    }

    private void validate(List<Integer> balls) {
        if (!isIncludedInRangeNumbers(balls)) {
            throw new IllegalArgumentException(WRONG_RANGE_NUMBER.getMessage());
        }

        if (!isAvailableLength(balls)) {
            throw new IllegalArgumentException(WRONG_COUNT_OF_NUMBER.getMessage());
        }

        if (isDuplicated(balls)) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER.getMessage());
        }

    }

    private Boolean isIncludedInRangeNumbers(List<Integer> balls) {
        return balls.stream()
                .allMatch(ball -> isIncludedInRangeNumber(ball));
    }

    private Boolean isIncludedInRangeNumber(Integer ball) {
        return (MIN_NUMBER.getSetting() <= ball && ball <= MAX_NUMBER.getSetting());
    }

    private Boolean isAvailableLength(List<Integer> balls) {
        return LENGTH.getSetting() == balls.size();
    }

    private Boolean isDuplicated(List<Integer> balls) {
        return LENGTH.getSetting() != balls.stream()
                .distinct()
                .collect(Collectors.toList())
                .size();
    }

    public List<Integer> getBalls() {
        return Collections.unmodifiableList(balls);
    }
}
