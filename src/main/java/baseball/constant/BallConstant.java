package baseball.constant;

public enum BallConstant {

    MIN_NUMBER(1),
    MAX_NUMBER(9);

    private final Integer setting;

    BallConstant(Integer setting) {
        this.setting = setting;
    }

    public Integer getSetting() {
        return setting;
    }
}
