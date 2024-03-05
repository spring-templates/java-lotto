package lotto.view;

import lotto.model.Lotto;
import lotto.util.Winnings;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

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
    public void outputWinningDetails(Map<Winnings, Integer> map) {
        System.out.println("당첨 통계\n---");
        for(Winnings w : map.keySet()){
            System.out.println(
                    w.getWinningDescription()+" ("+
                            formatNumberWithCommas(w.getWinningValue())+
                            "원) - "+map.get(w)+"개");
        }
    }

    private String formatNumberWithCommas(int number) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(number);
    }

    @Override
    public void outputRateOfReturn(String rateOfReturn) {
        System.out.println("총 수익률은 "+rateOfReturn+"%입니다.");
    }

    @Override
    public void displayErrorMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void displayWinningNumbersRequest() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    @Override
    public void displayBonusNumberRequest() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }
}
