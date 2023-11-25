package baseball.constant;

public enum ComputerBallsConstant {
    LENGTH(3);
    private final Integer setting;

    ComputerBallsConstant(Integer setting) {
        this.setting = setting;
    }

    public Integer getSetting() {
        return setting;
    }
}
