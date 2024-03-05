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

    public void runGame(){
        // 너무 길어지는 것 같다.
        InputManager inputManager = new UserInputManager();
        OutputManager outputManager = new SystemOutputManager();
        LottoGenerator lottoGenerator = new LottoGenerator(inputManager,outputManager);
        LottoResultCalculator lottoResultCalculator = new LottoResultCalculator(inputManager,outputManager);

        Customer customer = lottoGenerator.createCustomer();
        int lottoQuantity = lottoGenerator.countLottosBasedOnAmount(customer);
        outputManager.outputLottoQuantity(lottoQuantity);
        List<Lotto> lottos = lottoGenerator.createLottos(lottoQuantity);
        customer.withLottos(lottos);
        outputManager.outputLottoNumbers(lottos);
        LottoCompany lottoCompany = lottoResultCalculator.createLottoCompany();
        Map<Winnings,Integer> lottoResult = lottoResultCalculator.provideWinningDetails(customer, lottoCompany);

        outputManager.outputWinningDetails(lottoResult);
        String rateOrReturn = lottoResultCalculator.calculateReturn(lottoResult, customer);
        outputManager.outputRateOfReturn(rateOrReturn);
    }
}
