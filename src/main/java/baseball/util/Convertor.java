package baseball.util;

import java.util.ArrayList;
import java.util.List;

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
        return Integer.parseInt(input);
    }

}
