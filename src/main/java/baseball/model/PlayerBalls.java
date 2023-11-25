package baseball.model;

import baseball.util.Convertor;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerBalls {

    private static final Integer LENGTH = 3;
    private final List<Ball> balls;

    public PlayerBalls(List<Integer> numbers) {
        List<Ball> balls = Convertor.convertListToBalls(numbers);
        validate(balls);
        this.balls = balls;
    }

    private void validate(List<Ball> balls) {
        if (isDuplicated(balls)) {
            throw new IllegalArgumentException("[ERROR] 잘못된 값입니다.");
        }

        if (!isAvailableLength(balls)) {
            throw new IllegalArgumentException("[ERROR] 잘못된 길이입니다.");
        }
    }

    private Boolean isDuplicated(List<Ball> balls) {
        return LENGTH != balls
                .stream()
                .collect(Collectors.toSet())
                .size();
    }

    private Boolean isAvailableLength(List<Ball> balls) {
        return LENGTH == balls.size();
    }


    public Integer countStrike(List<Integer> numbers) {
        Integer count = 0;
        for (int i=0; i<LENGTH; i++) {
            Ball ball = balls.get(i);
            Integer number = numbers.get(i);
            if (ball.isSameBall(number)) {
                count += 1;
            }
        }

        return count;
    }

    public Integer countBall(List<Integer> numbers) {
        Integer count = 0;
        for (int i=0; i<LENGTH; i++) {
            Ball ball = balls.get(i);
            for (int j=0; j<LENGTH; j++) {
                if (i == j) continue;
                Integer number = numbers.get(j);
                if (ball.isSameBall(number)) {
                    count += 1;
                }
            }
        }

        return count;
    }


}
