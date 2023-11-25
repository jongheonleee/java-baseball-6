package baseball.view;

import baseball.util.Convertor;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {

    private static final String REQUEST_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String REQUEST_RESTART_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";


    public List<Integer> requestNumbers() {
        System.out.print(REQUEST_NUMBERS_MESSAGE);
        String input = getInput();
        validateNumbersFormat(input);
        return Convertor.convertStrToList(input);
    }

    private void validateNumbersFormat(String input) {
        if (isCommaAtEdge(input)) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력 형식입니다.");
        }

        if (isNotNumber(input)) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력 형식입니다.");
        }
    }

    private Boolean isCommaAtEdge(String input) {
        return input.charAt(0) == ',' || input.charAt(input.length()-1) == ',';
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
        System.out.println(REQUEST_RESTART_GAME_MESSAGE);
        String input = getInput();
        validateRestartFormat(input);
        return Convertor.convertStrToInt(input);
    }

    private void validateRestartFormat(String input) {
        if (isNotNumber(input)) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력 형식입니다.");
        }

        if (!isRightRestartInput(input)) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력 형식입니다.");
        }
    }

    private Boolean isRightRestartInput(String input) {
        return input.equals("1") || input.equals("2");
    }

    private String getInput() {
        return Console.readLine();
    }
}
