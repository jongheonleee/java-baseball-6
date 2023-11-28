package baseball.util;

public enum MessageFormat {
    ERROR_MESSAGE_PREFIX("[ERROR] : ");

    private final String format;

    MessageFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}
