package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GeneratorBalls {
    private static final Integer START_RANGE = 1;
    private static final Integer END_RANGE = 9;
    private static final Integer LENGTH = 3;

    public static List<Integer> generateUniqueNumbers() {
        List<Integer> numbers =generateNumbers();
        while (isDuplicated(numbers)) {
            numbers = generateNumbers();
        }
        return numbers;
    }

    private static List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i=0; i<LENGTH; i++) {
            numbers.add(pickNumber());
        }
        return numbers;
    }

    private static Integer pickNumber() {
        return Randoms.pickNumberInRange(START_RANGE, END_RANGE);
    }

    private static Boolean isDuplicated(List<Integer> numbers) {
        return LENGTH != numbers.stream()
                .distinct()
                .collect(Collectors.toList())
                .size();
    }
}
