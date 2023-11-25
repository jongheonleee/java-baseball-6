package baseball.model;

import baseball.util.Convertor;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static baseball.constant.PlayerBallsConstant.LENGTH;
public class PlayerBalls {

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
        return LENGTH.getSetting() != balls
                .stream()
                .collect(Collectors.toSet())
                .size();
    }

    private Boolean isAvailableLength(List<Ball> balls) {
        return LENGTH.getSetting() == balls.size();
    }


    public Integer countStrike(List<Integer> numbers) {
        Integer count = 0;
        for (int i=0; i<LENGTH.getSetting(); i++) {
            Ball ball = balls.get(i);
            Integer number = numbers.get(i);
            if (ball.isSameBall(number)) {
                count += 1;
            }
        }

        return count;
    }

    public Integer countBall(List<Integer> numbers) {
        return countStrikeAndBall(numbers) - countStrike(numbers);
    }

    private Integer countStrikeAndBall(List<Integer> numbers) {
        Integer count = 0;

        Set<Integer> numbersSet = numbers
                .stream()
                .collect(Collectors.toSet());

        for (int i=0; i<LENGTH.getSetting(); i++) {
            if (numbersSet.contains(balls.get(i))) {
                count += 1;
            }
        }

        return count;
    }


}
