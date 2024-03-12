package lotto.controller;

import lombok.AllArgsConstructor;
import lotto.model.Lotto;
import lotto.model.dto.Money;
import lotto.model.service.LottoGenerator;
import lotto.model.service.LottoResultCalculator;
import lotto.model.dto.PrizeNumbers;
import lotto.model.enums.Winnings;
import lotto.view.InputManager;
import lotto.view.OutputManager;

import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

@AllArgsConstructor
public class LottoController {
    private final InputManager inputManager;
    private final OutputManager outputManager;
    private final Random random;
    // 입력 처리 및 비즈니스 로직 통제
    public void runGame(){
        LottoGenerator lottoGenerator = new LottoGenerator(random);
        LottoResultCalculator lottoResultCalculator = new LottoResultCalculator();
        // 돈 받고 로또 생성
        Money money = getMoney(Lotto::validateMoney);
        int lottoQuantity = lottoGenerator.countQuentityBasedOnMoney(money);
        outputManager.outputLottoQuantity(lottoQuantity);
        List<Lotto> lottos = lottoGenerator.createLottos(lottoQuantity);
        outputManager.outputLottoNumbers(lottos);

        PrizeNumbers prizeNumbers = getPrizeNumbersForLotto();
        HashMap<Winnings,Integer> lottoResult = lottoResultCalculator.provideWinningDetails(lottos, prizeNumbers);
        outputManager.outputWinningDetails(lottoResult);
        String rateOrReturn = lottoResultCalculator.calculateReturn(lottoResult, money);
        outputManager.outputRateOfReturn(rateOrReturn);
    }

    // 로또를 사기 위한 구입 금액 입력
    // 만약 자동차를 사기 위한 Money를 입력 받는 경우가 생긴다면? 어떻게 할 수 있을까?
    // 함수형 인터페이스의 익명함수를 사용하면 유효성 검사 로직과 입력 받는 로직을 분리할 수 있다.
    private Money getMoney(Consumer<Money> vaildator){
        while(true){
            try{
                outputManager.displayMessage("구입금액을 입력해 주세요.");
                int amount = inputManager.enterPurchaseAmount(); // View
                Money money = new Money(amount);
                vaildator.accept(money);
                return money; // 데이터 생성
            }
            catch(IllegalArgumentException e){
                outputManager.displayMessage(e.getMessage());
            }
        }
    }

    private PrizeNumbers getPrizeNumbersForLotto(){
        // (w) -> Lotto.validateLottoNumbers(w)
        List<Integer> winningNumbers = retryWinningNumbers(Lotto::validateLottoNumbers);
        int bonusNumber = retryBonusNumber(winningNumbers, Lotto::validateBonusNumber);
        return new PrizeNumbers(winningNumbers, bonusNumber);
    }

    // Lotto를 위한 당첨금 받기
    private List<Integer> retryWinningNumbers(Consumer<List<Integer>> vaildator){
        while(true){
            try{
                outputManager.displayWinningNumbersRequest();
                List<Integer> winningNumbers = inputManager.enterWinningNumbers();
                vaildator.accept(winningNumbers);
                return winningNumbers;
            }
            catch(IllegalArgumentException e){
                outputManager.displayMessage(e.getMessage());
            }
        }
    }

    // Lotto를 위한 보너스 받기
    private int retryBonusNumber(List<Integer> winningNumbers, BiConsumer<List<Integer>, Integer> vaildator){
        while(true){
            try{
                outputManager.displayBonusNumberRequest();
                int bonusNumber = inputManager.enterBonusNumber();
                vaildator.accept(winningNumbers, bonusNumber);
                return bonusNumber;
            }
            catch(IllegalArgumentException e){
                outputManager.displayMessage(e.getMessage());
            }
        }
    }
}
