package baseball.model;

import baseball.exception.PlayerBallsExceptionMessage;
import baseball.util.Convertor;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static baseball.constant.PlayerBallsConstant.INIT;
import static baseball.constant.PlayerBallsConstant.LENGTH;
import static baseball.exception.PlayerBallsExceptionMessage.*;

public class PlayerBalls {

    private final List<Ball> balls;

    public PlayerBalls(List<Integer> numbers) {
        List<Ball> balls = Convertor.convertListToBalls(numbers);
        validate(balls);
        this.balls = balls;
    }

    private void validate(List<Ball> balls) {
        if (isDuplicated(balls)) {
            throw new IllegalArgumentException(WRONG_COUNT_OF_NUMBER.getMessage());
        }

        if (!isAvailableLength(balls)) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER.getMessage());
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
        Integer count = INIT.getSetting();
        for (int i=0; i<LENGTH.getSetting(); i++) {
            Integer number = numbers.get(i);
            count += isNumberOnPosition(number, i);
        }
        return count;
    }

    public Integer countBall(List<Integer> numbers) {
        return countStrikeAndBall(numbers) - countStrike(numbers);
    }

    private Integer countStrikeAndBall(List<Integer> numbers) {
        Integer count = INIT.getSetting();
        for (Integer number : numbers) {
            count += isNumber(number);
        }
        return count;
    }

    private Integer isNumber(Integer number) {
        return Math.toIntExact(balls.stream()
                .filter(ball -> ball.isSameBall(number))
                .count());
    }

    private Integer isNumberOnPosition(Integer number, Integer position) {
        Ball ball = balls.get(position);
        return ball.isSameBall(number) == true ? 1 : 0;
    }


}
