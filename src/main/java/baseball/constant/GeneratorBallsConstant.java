package baseball.constant;

public enum GeneratorBallsConstant {
    START_NUMBER(1),
    END_NUMBER(9),
    LENGTH(3);

    private final Integer setting;

    GeneratorBallsConstant(Integer setting) {
        this.setting = setting;
    }

    public Integer getSetting() {
        return setting;
    }
}
