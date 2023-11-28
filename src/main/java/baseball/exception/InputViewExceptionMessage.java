package baseball.exception;

import static baseball.util.MessageFormat.*;

import baseball.util.MessageFormat;

public enum InputViewExceptionMessage {
    WRONG_INPUT_FORMAT("잘못된 입력 형식입니다.");

    private final String message;

    InputViewExceptionMessage(String message) {
        this.message = ERROR_MESSAGE_PREFIX.getFormat() + message;
    }

    public String getMessage() {
        return message;
    }
}
