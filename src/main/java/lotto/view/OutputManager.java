package lotto.view;

import lotto.model.Lotto;

import java.util.List;

public interface OutputManager {
    void outputLottoQuantity(int quantity);
    void outputLottoNumbers(List<Lotto> lottoList);
    void outputWinningDetails(List<String> details);
    void outputRateOfReturn(float rateOfReturn);
    void displayErrorMessage(String message);
}
