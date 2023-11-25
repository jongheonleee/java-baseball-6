package baseball.view;

public class OutputView {

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final StringBuilder stringBuilder;

    public OutputView(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
    }

    public void printGameStart() {
        initStringBuilder();
        stringBuilder.append(GAME_START_MESSAGE);
        printStringBuilder();
    }


    public void printPlayerResult(String message) {
        initStringBuilder();
        stringBuilder.append(message);
        printStringBuilder();
    }

    public void printGameEnd() {
        initStringBuilder();
        stringBuilder.append(GAME_END_MESSAGE);
        printStringBuilder();
    }

    private void initStringBuilder() {
        stringBuilder.setLength(0);
    }

    private void printStringBuilder() {
        System.out.println(stringBuilder);
    }
}
