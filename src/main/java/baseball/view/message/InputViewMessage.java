package baseball.view.message;

public enum InputViewMessage {
    REQUEST_NUMBERS_MESSAGE("숫자를 입력해주세요 : "),
    REQUEST_RESTART_GAME_MESSAGE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private final String message;

    InputViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
