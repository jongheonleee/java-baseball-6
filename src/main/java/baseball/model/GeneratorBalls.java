package baseball.model;

import static baseball.constant.GeneratorBallsConstant.END_NUMBER;
import static baseball.constant.GeneratorBallsConstant.LENGTH;
import static baseball.constant.GeneratorBallsConstant.START_NUMBER;

import baseball.util.Generator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GeneratorBalls {

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
        for (int i=0; i< LENGTH.getSetting(); i++) {
            Integer number = generator.pickNumber(START_NUMBER.getSetting(), END_NUMBER.getSetting());
            numbers.add(number);
        }
        return numbers;
    }


    private Boolean isDuplicated(List<Integer> numbers) {
        return LENGTH.getSetting() != numbers.stream()
                .distinct()
                .collect(Collectors.toList())
                .size();
    }
}
