package lotto;

import lotto.controller.LottoGenerator;
import lotto.controller.LottoResultCalculator;
import lotto.model.Customer;
import lotto.view.InputManager;
import lotto.view.OutputManager;
import lotto.view.SystemOutputManager;
import lotto.view.UserInputManager;

public class LottoManager {
    private final InputManager inputManager = new UserInputManager();
    private final OutputManager outputManager = new SystemOutputManager();
    private final LottoGenerator lottoGenerator = new LottoGenerator();
    private final LottoResultCalculator lottoResultCalculator = new LottoResultCalculator();

    public void runGame(){
        lottoGenerator.createCustomer(inputManager, outputManager);
//        int
    }
}
