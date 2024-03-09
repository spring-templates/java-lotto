package lotto.controller;

import lombok.AllArgsConstructor;
import lotto.model.Lotto;
import lotto.model.Money;
import lotto.model.service.LottoGenerator;
import lotto.model.service.LottoResultCalculator;
import lotto.model.PrizeNumbers;
import lotto.util.LottoValidator;
import lotto.view.InputManager;
import lotto.view.OutputManager;

import java.util.List;

@AllArgsConstructor
public class LottoController {
    private final InputManager inputManager;
    private final OutputManager outputManager;
    // 입력 처리 및 비즈니스 로직 통제
    public void runGame(){
        LottoGenerator lottoGenerator = new LottoGenerator();
        LottoResultCalculator lottoResultCalculator = new LottoResultCalculator();

        Money money = getMoneyforLotto();
        int lottoQuantity = lottoGenerator.countLottosBasedOnAmount(money);
        outputManager.outputLottoQuantity(lottoQuantity);
//        List<Lotto> lottos = lottoGenerator.createLottos(lottoQuantity);
//        customer.withLottos(lottos);
//        outputManager.outputLottoNumbers(lottos);
//
//        PrizeNumbers prizeNumbers = retryCreatePrizeNumbers();
//        Map<Winnings,Integer> lottoResult = lottoResultCalculator.provideWinningDetails(customer.getLottos(), prizeNumbers);
//        outputManager.outputWinningDetails(lottoResult);
//        String rateOrReturn = lottoResultCalculator.calculateReturn(lottoResult, customer.getPurchaseAmount());
//        outputManager.outputRateOfReturn(rateOrReturn);
    }

    // 로또를 사기위한 구입금액 입력
    private Money getMoneyforLotto(){
        while(true){
            try{
                int amount = inputManager.enterPurchaseAmount(); // View
                Money money = new Money(amount);
                Lotto.validateMoney(money);
                return new Money(amount); // 데이터 생성
            }
            catch(IllegalArgumentException e){
                outputManager.displayErrorMessage(e.getMessage());
            }
        }
    }
    private PrizeNumbers retryCreatePrizeNumbers(){
        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers);
        return new PrizeNumbers(winningNumbers, bonusNumber);
    }

    private List<Integer> getWinningNumbers(){
        while(true){
            try{
                outputManager.displayWinningNumbersRequest();
                List<Integer> winningNumbers = inputManager.enterWinningNumbers();
                LottoValidator.checkLottoVaild(winningNumbers);
                return winningNumbers;
            }
            catch(IllegalArgumentException e){
                outputManager.displayErrorMessage(e.getMessage());
            }
        }
    }

    private int getBonusNumber(List<Integer> winningNumbers){
        while(true){
            try{
                outputManager.displayBonusNumberRequest();
                int bonusNumber = inputManager.enterBonusNumber();
                LottoValidator.checkBonusNumber(winningNumbers, bonusNumber);
                return bonusNumber;
            }
            catch(IllegalArgumentException e){
                outputManager.displayErrorMessage(e.getMessage());
            }
        }
    }
}
