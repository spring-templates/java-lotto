package lotto.view;

import lotto.model.Lotto;
import lotto.util.Winnings;

import java.util.List;
import java.util.Map;

public interface OutputManager {
    void outputLottoQuantity(int quantity);
    void outputLottoNumbers(List<Lotto> lottoList);
    void outputWinningDetails(Map<Winnings, Integer> map);
    void outputRateOfReturn(String rateOfReturn);
    void displayErrorMessage(String message);
    void displayWinningNumbersRequest();
    void displayBonusNumberRequest();
}
