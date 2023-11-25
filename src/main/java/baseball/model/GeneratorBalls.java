package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GeneratorBalls {
    private static final Integer START_RANGE = 1;
    private static final Integer END_RANGE = 9;
    private static final Integer LENGTH = 3;

    private final Generator generator;

    public GeneratorBalls(Generator generator) {
        this.generator = generator;
    }

    public List<Integer> generateUniqueNumbers() {
        List<Integer> numbers = generateNumbers();
        while (isDuplicated(numbers)) {
            numbers = generateNumbers();
        }
        return numbers;
    }

    private List<Integer> generateNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i=0; i<LENGTH; i++) {
            Integer number = generator.pickNumber(START_RANGE, END_RANGE);
            numbers.add(number);
        }
        return numbers;
    }


    private Boolean isDuplicated(List<Integer> numbers) {
        return LENGTH != numbers.stream()
                .distinct()
                .collect(Collectors.toList())
                .size();
    }
}
