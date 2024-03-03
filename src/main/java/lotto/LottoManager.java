package lotto;

import lotto.controller.LottoGenerator;
import lotto.controller.LottoResultCalculator;
import lotto.model.Customer;
import lotto.model.Lotto;
import lotto.model.LottoCompany;
import lotto.util.Winnings;
import lotto.view.InputManager;
import lotto.view.OutputManager;
import lotto.view.SystemOutputManager;
import lotto.view.UserInputManager;

import java.util.List;
import java.util.Map;

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
        customer.withLottos(lottos);
        outputManager.outputLottoNumbers(lottos);
        LottoCompany lottoCompany = lottoResultCalculator.createLottoCompany(inputManager,outputManager);
        System.out.println(lottoCompany.winningNumbers());
        System.out.println(lottoCompany.bonusNumber());
        Map<Winnings,Integer> lottoResult = lottoResultCalculator.provideWinningDetails(customer, lottoCompany);
        outputManager.outputWinningDetails(lottoResult);
        String rateOrReturn = lottoResultCalculator.calculateReturn(lottoResult, customer);
        outputManager.outputRateOfReturn(rateOrReturn);
    }
}
