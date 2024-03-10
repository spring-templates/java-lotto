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
        // 돈 받고 로또 생성
        Money money = getMoneyforLotto();
        int lottoQuantity = lottoGenerator.countQuentityBasedOnMoney(money);
        outputManager.outputLottoQuantity(lottoQuantity);
        List<Lotto> lottos = lottoGenerator.createLottos(lottoQuantity);
        outputManager.outputLottoNumbers(lottos);

        PrizeNumbers prizeNumbers = retryCreatePrizeNumbers();
//        Map<Winnings,Integer> lottoResult = lottoResultCalculator.provideWinningDetails(customer.getLottos(), prizeNumbers);
//        outputManager.outputWinningDetails(lottoResult);
//        String rateOrReturn = lottoResultCalculator.calculateReturn(lottoResult, customer.getPurchaseAmount());
//        outputManager.outputRateOfReturn(rateOrReturn);
    }

    // 로또를 사기 위한 구입 금액 입력
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
        List<Integer> winningNumbers = retryWinningNumbers();
        int bonusNumber = retryBonusNumber(winningNumbers);
        return new PrizeNumbers(winningNumbers, bonusNumber);
    }

    // Lotto를 위한 당첨금 받기
    private List<Integer> retryWinningNumbers(){
        while(true){
            try{
                outputManager.displayWinningNumbersRequest();
                List<Integer> winningNumbers = inputManager.enterWinningNumbers();
                PrizeNumbers.validateLottoNumbers(winningNumbers);
                return winningNumbers;
            }
            catch(IllegalArgumentException e){
                outputManager.displayErrorMessage(e.getMessage());
            }
        }
    }
    // Lotto를 위한 보너스 받기
    private int retryBonusNumber(List<Integer> winningNumbers){
        while(true){
            try{
                outputManager.displayBonusNumberRequest();
                int bonusNumber = inputManager.enterBonusNumber();
                PrizeNumbers.validateBonusNumber(winningNumbers, bonusNumber);
                return bonusNumber;
            }
            catch(IllegalArgumentException e){
                outputManager.displayErrorMessage(e.getMessage());
            }
        }
    }
}
