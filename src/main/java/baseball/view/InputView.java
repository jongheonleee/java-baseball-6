package baseball.view;

import static baseball.exception.InputViewExceptionMessage.WRONG_INPUT_FORMAT;
import static baseball.util.CharacterUtil.COMMA;
import static baseball.view.message.InputViewMessage.REQUEST_NUMBERS_MESSAGE;
import static baseball.view.message.InputViewMessage.REQUEST_RESTART_GAME_MESSAGE;

import baseball.util.Convertor;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {

    public List<Integer> requestNumbers() {
        System.out.print(REQUEST_NUMBERS_MESSAGE.getMessage());
        String input = getInput();
        validateNumbersFormat(input);
        return Convertor.convertStrToList(input);
    }

    private void validateNumbersFormat(String input) {
        if (isCommaAtEdge(input)) {
            throw new IllegalArgumentException(WRONG_INPUT_FORMAT.getMessage());
        }

        if (isNotNumber(input)) {
            throw new IllegalArgumentException(WRONG_INPUT_FORMAT.getMessage());
        }
    }

    private Boolean isCommaAtEdge(String input) {
        return input.charAt(0) == COMMA.getUnit() || input.charAt(input.length()-1) == COMMA.getUnit();
    }

    private Boolean isNotNumber(String input) {
        Boolean answer = false;

        for (int i=0; i<input.length(); i++) {
            Character token = input.charAt(i);
            if (!Character.isDigit(token)) {
                answer = true;
            }
        }

        return answer;
    }

    public Integer requestRestart() {
        System.out.println(REQUEST_RESTART_GAME_MESSAGE.getMessage());
        String input = getInput();
        validateRestartFormat(input);
        return Convertor.convertStrToInt(input);
    }

    private void validateRestartFormat(String input) {
        if (isNotNumber(input)) {
            throw new IllegalArgumentException(WRONG_INPUT_FORMAT.getMessage());
        }

        if (!isRightRestartInput(input)) {
            throw new IllegalArgumentException(WRONG_INPUT_FORMAT.getMessage());
        }
    }

    private Boolean isRightRestartInput(String input) {
        Integer number = Convertor.convertStrToInt(input);
        return 1 == number || 2 == number;
    }

    private String getInput() {
        return Console.readLine();
    }
}
