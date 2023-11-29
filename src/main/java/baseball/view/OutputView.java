package baseball.view;

import static baseball.view.message.OutputViewMessage.GAME_END_MESSAGE;
import static baseball.view.message.OutputViewMessage.GAME_START_MESSAGE;

public class OutputView {
    private final StringBuilder stringBuilder;

    public OutputView(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
    }

    public void printGameStart() {
        initStringBuilder();
        stringBuilder.append(GAME_START_MESSAGE.getMessage());
        printStringBuilder();
    }


    public void printPlayerResult(String message) {
        initStringBuilder();
        stringBuilder.append(message);
        printStringBuilder();
    }

    public void printEndGame() {
        initStringBuilder();
        stringBuilder.append(GAME_END_MESSAGE.getMessage());
        printStringBuilder();
    }

    private void initStringBuilder() {
        stringBuilder.setLength(0);
    }

    private void printStringBuilder() {
        System.out.println(stringBuilder);
    }
}
