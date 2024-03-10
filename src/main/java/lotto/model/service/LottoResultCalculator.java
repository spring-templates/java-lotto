package lotto.model.service;

import lombok.AllArgsConstructor;
import lotto.model.Lotto;
import lotto.model.Money;
import lotto.model.PrizeNumbers;
import lotto.model.Winnings;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class LottoResultCalculator {

    public HashMap<Winnings, Integer> provideWinningDetails(List<Lotto> customerLottos, PrizeNumbers prizeNumbers){
        HashMap<Winnings, Integer> map = newWinningsMap();
        customerLottos.forEach(lotto -> {
            int winningMatchCount = checkWinningElement(lotto.numbers(), prizeNumbers.winningNumbers());
            boolean bonusMatchCount = checkBonusElement(lotto.numbers(), prizeNumbers.bonusNumber());
            Winnings winnings = Winnings.of(winningMatchCount,bonusMatchCount);
            map.put(winnings, map.get(winnings)+1);
        });
        return map;
    }

    private HashMap<Winnings, Integer> newWinningsMap(){
        HashMap<Winnings, Integer> map = new LinkedHashMap<>(); // 입력 순서를 보장하면서 Map을 사용할 수 있는 자료형
        for(Winnings w : Winnings.values()){
            map.put(w,0);
        }
        return map;
    }

    private boolean checkBonusElement(List<Integer> a, int b){
        return a.contains(b);
    }

    // 크기가 6이고 정렬된 두 배열에서 동일한 요소 개수 찾기
    private int checkWinningElement(List<Integer> a, List<Integer>b){
        return (int) a.stream().filter(b::contains).count();
    }

    public String calculateReturn(HashMap<Winnings, Integer> lottoResult, Money money) {
        return  String.format("%.1f", (double) totalPrice(lottoResult)*100/money.getMoney());
    }
    private int totalPrice(HashMap<Winnings, Integer> lottoResult){
        int result = 0;
        for(Winnings w : lottoResult.keySet()){
            result += w.getWinningValue()*lottoResult.get(w);
        }
        return result;
    }
}
