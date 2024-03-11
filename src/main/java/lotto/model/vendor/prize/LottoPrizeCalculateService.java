package lotto.model.vendor.prize;

import java.util.*;
import lotto.model.entity.*;

class LottoPrizeCalculateService implements IPrizeVendor<Lotto, LottoPrize> {

    private final Lotto winningLotto;
    private final LottoBonusNumber winningBonusNumber;

    public LottoPrizeCalculateService(Lotto winningLotto, LottoBonusNumber winningBonusNumber) {
        this.winningLotto = winningLotto;
        this.winningBonusNumber = winningBonusNumber;
    }

    @Override
    public SortedMap<LottoPrize, Integer> countPrize(List<Lotto> lottoList) {
        SortedMap<LottoPrize, Integer> prizeMap = new TreeMap<>();
        for (Lotto lotto : lottoList) {
            int count = winningLotto.countMatch(lotto);
            boolean isBonusMatched = lotto.contains(winningBonusNumber);
            LottoPrize prize = LottoPrize.of(count, isBonusMatched);
            prizeMap.put(prize, prizeMap.getOrDefault(prize, 0) + 1);
        }
        return prizeMap;
    }

    @Override
    public double calculateProfitRate(Map<LottoPrize, Integer> prizeMap) {
        double totalPrize = calculateTotalPrize(prizeMap);
        double totalCost = calculateTotalCost(prizeMap);
        return totalPrize / totalCost * 100;
    }


    private double calculateTotalPrize(Map<LottoPrize, Integer> prizeMap) {
        double[] totalPrice = {0.};
        prizeMap.forEach((k, v) -> totalPrice[0] += k.getPrice().amount() * v);
        return totalPrice[0];
    }

    private double calculateTotalCost(Map<LottoPrize, Integer> prizeMap) {
        double[] totalCost = {0.};
        int lottoPrice = winningLotto.getPrice().amount();
        prizeMap.forEach((k, v) -> totalCost[0] += lottoPrice * v);
        return totalCost[0];
    }
}
