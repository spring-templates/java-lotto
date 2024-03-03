package lotto.controller;

import lotto.model.Customer;
import lotto.model.LottoCompany;
import lotto.util.Winnings;
import lotto.view.InputManager;
import lotto.view.OutputManager;
import java.util.List;
import java.util.Map;

public class LottoResultCalculator {

    public LottoCompany createLottoCompany(InputManager inputManager, OutputManager outputManager){
        LottoCompany.Builder builder = getWinningNumbers(inputManager, outputManager);
        return getBonusNumber(inputManager, outputManager, builder);
    }

    private LottoCompany.Builder getWinningNumbers(InputManager inputManager, OutputManager outputManager){
        LottoCompany.Builder builder =  new LottoCompany.Builder();
        while(true){
            try{
                outputManager.displayWinningNumbersRequest();
                List<Integer> winningNumbers = inputManager.enterWinningNumbers();
                return builder.winningNumbers(winningNumbers);
            }
            catch(IllegalArgumentException e){
                outputManager.displayErrorMessage(e.getMessage());
            }
        }
    }

    private LottoCompany getBonusNumber(InputManager inputManager, OutputManager outputManager, LottoCompany.Builder builder){
        while(true){
            try{
                outputManager.displayBonusNumberRequest();
                int bonusNumber = inputManager.enterBonusNumber();
                builder.bonusNumber(bonusNumber);
                return builder.build();
            }
            catch(IllegalArgumentException e){
                outputManager.displayErrorMessage(e.getMessage());
            }
        }
    }

    public Map<Winnings, Integer> provideWinningDetails(Customer customer, LottoCompany lottoCompany){
        Map<Winnings, Integer> map = Winnings.newWinningsMap();
        customer.lottos().forEach(lotto -> {
            int winningMatchCount = checkWinningElement(lotto.numbers(), lottoCompany.winningNumbers());
            int bonusMatchCount =checkBonusElement(lotto.numbers(),lottoCompany.bonusNumber());
            Winnings winnings = Winnings.valueOfWinningsAndBonus(winningMatchCount,bonusMatchCount);
            if(winnings != null){
                map.put(winnings, map.get(winnings)+1);
            }
        });
        return map;
    }

    private int checkBonusElement(List<Integer> a, int b){
        if(a.contains(b))
            return 1;
        return 0;
    }

    // 크기가 6이고 정렬된 두 배열에서 동일한 요소 개수 찾기
    private int checkWinningElement(List<Integer> a, List<Integer>b){
        int idxA = 0;
        int idxB = 0;
        int result = 0;
        while(idxA<6 && idxB<6){
            if(a.get(idxA).equals(b.get(idxB))){
                result++;
                idxA++;
                idxB++;
            }
            if(a.get(idxA) > b.get(idxB))
                idxB++;
            if(a.get(idxA) < b.get(idxB))
                idxA++;
        }
        return result;
    }

    public String calculateReturn(Map<Winnings, Integer> lottoResult, Customer customer) {
        return  String.format("%.1f", (double) totalPrice(lottoResult)/customer.purchaseAmount());
    }
    private int totalPrice(Map<Winnings, Integer> lottoResult){
        int result = 0;
        for(Winnings w : lottoResult.keySet()){
            result += w.getWinningValue()*lottoResult.get(w);
        }
        return result;
    }
}
