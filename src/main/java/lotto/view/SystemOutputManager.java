package lotto.view;

import lotto.model.Lotto;

import java.util.List;

public class SystemOutputManager implements OutputManager{
    @Override
    public void outputLottoQuantity(int quantity) {
        System.out.println(quantity+"개를 구매했습니다.");
    }

    @Override
    public void outputLottoNumbers(List<Lotto> lottoList) {
        lottoList.forEach(lotto ->
                System.out.println(lotto.toString()));
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
