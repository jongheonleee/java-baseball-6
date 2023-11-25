package baseball;

import baseball.controller.GameController;
import baseball.util.Generator;
import baseball.model.GeneratorBalls;
import baseball.util.GeneratorImp;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView(new StringBuilder());
        Generator generatorImp = new GeneratorImp();
        GeneratorBalls generatorBalls = new GeneratorBalls(generatorImp);
        GameController gameController = new GameController(inputView, outputView, generatorBalls);
        gameController.play();
    }
}
