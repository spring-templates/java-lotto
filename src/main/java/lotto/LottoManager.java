package lotto;

import lotto.controller.LottoGenerator;
import lotto.controller.LottoResultCalculator;
import lotto.model.Customer;
import lotto.model.Lotto;
import lotto.view.InputManager;
import lotto.view.OutputManager;
import lotto.view.SystemOutputManager;
import lotto.view.UserInputManager;

import java.util.List;

public class LottoManager {
    private final InputManager inputManager = new UserInputManager();
    private final OutputManager outputManager = new SystemOutputManager();
    private final LottoGenerator lottoGenerator = new LottoGenerator();
    private final LottoResultCalculator lottoResultCalculator = new LottoResultCalculator();

    public void runGame(){
        Customer customer = lottoGenerator.createCustomer(inputManager, outputManager);
        int lottoQuantity = lottoGenerator.countLottosBasedOnAmount(customer);
        outputManager.outputLottoQuantity(lottoQuantity);
        List<Lotto> lottos = lottoGenerator.createLottos(lottoQuantity);
        outputManager.outputLottoNumbers(lottos);

    }
}
