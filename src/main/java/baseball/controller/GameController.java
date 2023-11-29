package baseball.controller;

import static baseball.model.PlayerResult.*;

import baseball.model.ComputerBalls;
import baseball.model.GeneratorBalls;
import baseball.model.PlayerBalls;
import baseball.model.PlayerResult;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final GeneratorBalls generatorBalls;

    public GameController(InputView inputView, OutputView outputView, GeneratorBalls generatorBalls) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.generatorBalls = generatorBalls;
    }

    public void play() {
        do {
            processGame();
        } while (restartGame());
    }

    private void processGame() {
        ComputerBalls computerBalls = createComputerBalls();
        PlayerResult playerResult = oneCycle(computerBalls);
        while (!playerResult.equals(PlayerResult.THREE_STRIKE)) {
            playerResult = oneCycle(computerBalls);
        }
    }

    private ComputerBalls createComputerBalls() {
        outputView.printGameStart();
        List<Integer> numbers = generatorBalls.generateUniqueNumbers();
        ComputerBalls computerBalls = new ComputerBalls(numbers);
        return computerBalls;
    }

    private PlayerBalls createPlayerBalls() {
        List<Integer> numbers = inputView.requestNumbers();
        PlayerBalls playerBalls = new PlayerBalls(numbers);
        return playerBalls;
    }

    private PlayerResult compareComputerBallsAndPlayerBalls(ComputerBalls computerBalls, PlayerBalls playerBalls) {
        Integer strike = playerBalls.countStrike(computerBalls.getBalls());
        Integer ball = playerBalls.countBall(computerBalls.getBalls());
        return PlayerResult.of(strike, ball);
    }

    private PlayerResult oneCycle(ComputerBalls computerBalls) {
        PlayerBalls playerBalls = createPlayerBalls();
        PlayerResult playerResult = compareComputerBallsAndPlayerBalls(computerBalls, playerBalls);
        outputView.printPlayerResult(playerResult.getMessage());
        return playerResult;
    }


    private Boolean restartGame() {
        outputView.printEndGame();
        Integer answer = inputView.requestRestart();
        return answer == 1;
    }
}
