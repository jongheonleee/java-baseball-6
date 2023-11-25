package baseball.model;

import baseball.view.InputView;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ComputerBalls {

    private static final Integer MIN_NUMBER = 1;
    private static final Integer MAX_NUMBER = 9;

    private static final Integer LENGTH = 3;

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
        return (MIN_NUMBER <= ball && ball <= MAX_NUMBER);
    }

    private Boolean isAvailableLength(List<Integer> balls) {
        return LENGTH == balls.size();
    }

    private Boolean isDuplicated(List<Integer> balls) {
        return LENGTH != balls.stream()
                .distinct()
                .collect(Collectors.toList())
                .size();
    }

    public List<Integer> getBalls() {
        return Collections.unmodifiableList(balls);
    }
}
