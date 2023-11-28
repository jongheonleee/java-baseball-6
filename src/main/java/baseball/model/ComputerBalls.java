package baseball.model;

import static baseball.constant.BallConstant.MAX_NUMBER;
import static baseball.constant.BallConstant.MIN_NUMBER;
import static baseball.constant.ComputerBallsConstant.LENGTH;

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
            throw new IllegalArgumentException("[ERROR] 잘못된 값입니다.");
        }

        if (!isAvailableLength(balls)) {
            throw new IllegalArgumentException("[ERROR] 잘못된 길이입니다.");
        }

        if (isDuplicated(balls)) {
            throw new IllegalArgumentException("[ERROR] 잘못된 값입니다.");
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
