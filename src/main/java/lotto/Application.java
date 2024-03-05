package lotto;

import lotto.controller.LottoController;
import lotto.model.service.LottoGenerator;
import lotto.view.InputManager;
import lotto.view.OutputManager;
import lotto.view.SystemOutputManager;
import lotto.view.UserInputManager;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputManager inputManager = new UserInputManager();
        OutputManager outputManager = new SystemOutputManager();

        LottoController lottoController = new LottoController(inputManager, outputManager);
        lottoController.runGame();
    }
}
