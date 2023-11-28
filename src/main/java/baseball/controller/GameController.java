package baseball.controller;

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
    private ComputerBalls computerBalls;
    private PlayerBalls playerBalls;

    public GameController(InputView inputView, OutputView outputView, GeneratorBalls generatorBalls) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.generatorBalls = generatorBalls;
    }

    public void play() {
        do {
            gameProcess();
        } while (restartGame());
    }

    private void gameProcess() {
        createComputerBalls();
        generatePlayerResult();
    }

    private void createComputerBalls() {
        outputView.printGameStart();
        List<Integer> numbers = generatorBalls.generateUniqueNumbers();
        computerBalls = new ComputerBalls(numbers);
    }

    private void createPlayerBalls() {
        List<Integer> numbers = inputView.requestNumbers();
        playerBalls = new PlayerBalls(numbers);
    }

    private void generatePlayerResult() {
        PlayerResult result;
        do {
            createPlayerBalls();
            Integer strike = playerBalls.countStrike(computerBalls.getBalls());
            Integer ball = playerBalls.countBall(computerBalls.getBalls());
            result = PlayerResult.of(strike, ball);
            outputView.printPlayerResult(result.getMessage());
        } while (!result.equals(PlayerResult.THREE_STRIKE));
    }

    private Boolean restartGame() {
        outputView.printGameEnd();
        Integer answer = inputView.requestRestart();
        return answer == 1 ? true : false;
    }
}
