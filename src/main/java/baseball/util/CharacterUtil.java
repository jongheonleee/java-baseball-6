package baseball.util;

public enum CharacterUtil {
    COMMA(',');

    private final Character unit;

    CharacterUtil(Character unit) {
        this.unit = unit;
    }

    public Character getUnit() {
        return unit;
    }
}
