package baseball.exception;

import static baseball.util.MessageFormat.*;

import baseball.util.MessageFormat;

public enum BallExceptionMessage {
    WRONG_RANGE_NUMBER("잘못된 범위의 숫자입니다.");

    private final String message;

    BallExceptionMessage(String message) {
        this.message = ERROR_MESSAGE_PREFIX.getFormat() + message;
    }

    public String getMessage() {
        return message;
    }
}
