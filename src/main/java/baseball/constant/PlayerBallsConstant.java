package baseball.constant;

public enum PlayerBallsConstant {

    LENGTH(3),
    INIT(0);
    private final Integer setting;

    PlayerBallsConstant(Integer setting) {
        this.setting = setting;
    }

    public Integer getSetting() {
        return setting;
    }
}
