package lotto.view;

import lotto.model.Lotto;

import java.util.List;

public class SystemOutputManager implements OutputManager{
    @Override
    public void outputLottoQuantity(int quantity) {

    }

    @Override
    public void outputLottoNumbers(List<Lotto> lottoList) {

    }

    @Override
    public void outputWinningDetails(List<String> details) {

    }

    @Override
    public void outputRateOfReturn(float rateOfReturn) {

    }

    @Override
    public void displayErrorMessage(String message) {
        System.out.println(message);
    }
}
