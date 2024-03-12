package lotto.view;

import lotto.model.Lotto;
import lotto.model.enums.Winnings;

import java.util.HashMap;
import java.util.List;

public interface OutputManager {
    void outputLottoQuantity(int quantity);
    void outputLottoNumbers(List<Lotto> lottoList);
    void outputWinningDetails(HashMap<Winnings, Integer> map);
    void outputRateOfReturn(String rateOfReturn);
    void displayMessage(String message);
    void displayWinningNumbersRequest();
    void displayBonusNumberRequest();
}
