package baseball.exception;

import static baseball.util.MessageFormat.*;

import baseball.util.MessageFormat;

public enum ConvertorExceptionMessage {
    NOT_NUMBER("잘못된 입력값입니다. 숫자를 입력해주세요");

    private final String message;

    ConvertorExceptionMessage(String message) {
        this.message = ERROR_MESSAGE_PREFIX.getFormat() + message;
    }

    public String getMessage() {
        return message;
    }
}
