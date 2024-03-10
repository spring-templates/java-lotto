package lotto.view;

import lotto.model.Lotto;
import lotto.model.Winnings;
import java.text.DecimalFormat;
import java.util.HashMap;
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
    public void outputWinningDetails(HashMap<Winnings, Integer> map) {
        System.out.println("당첨 통계\n---");
        for(Winnings w : map.keySet()){
            StringBuilder stringBuilder = new StringBuilder();
            if(w.equals(Winnings.Fail))continue;
            stringBuilder.append(w.getWinningMatchCount());
            stringBuilder.append("개 일치");
            if(w.isBonusMatchCount())//w의 보너스 카운트 얻기 true면 아래 코드 실행
                stringBuilder.append(", 보너스 볼 일치");
            stringBuilder.append(" (");
            stringBuilder.append(formatNumberWithCommas(w.getWinningValue()));
            stringBuilder.append("원) - ");
            stringBuilder.append(map.get(w));
            stringBuilder.append("개");
            System.out.println(stringBuilder);
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
