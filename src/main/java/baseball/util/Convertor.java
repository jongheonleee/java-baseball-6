package baseball.util;

import baseball.model.Ball;
import baseball.model.PlayerBalls;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Convertor {

    public static List<Integer> convertStrToList(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (int i=0; i<input.length(); i++) {
            Character token = input.charAt(i);
            Integer number = Character.getNumericValue(token);
            numbers.add(number);
        }
        return numbers;
    }

    public static Integer convertStrToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력값입니다. 숫자를 입력해주세요");
        }
    }

    public static Ball convertIntToBall(Integer number) {
        return new Ball(number);
    }

    public static List<Ball> convertListToBalls(List<Integer> numbers) {
        return numbers.stream()
                .map(Convertor::convertIntToBall)
                .collect(Collectors.toList());
    }
}
