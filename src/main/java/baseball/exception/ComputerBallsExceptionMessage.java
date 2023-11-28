package baseball.exception;

import static baseball.util.MessageFormat.*;

import baseball.util.MessageFormat;

public enum ComputerBallsExceptionMessage {
    WRONG_RANGE_NUMBER("잘못된 범위의 숫자입니다."),
    WRONG_COUNT_OF_NUMBER("잘못된 숫자 개수입니다."),
    DUPLICATED_NUMBER("중복된 숫자가 있습니다.");

    private final String message;

    ComputerBallsExceptionMessage(String message) {
        this.message = ERROR_MESSAGE_PREFIX.getFormat() + message;
    }

    public String getMessage() {
        return message;
    }
}
