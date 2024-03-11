package lotto.model.vendor.prize;

import java.util.*;
import lotto.model.entity.*;
import lotto.model.vendor.LottoVendor;

public class LottoPrizeVendor extends LottoVendor implements IPrizeVendor<Lotto, LottoPrize> {

    private final LottoPrizeCalculateService prizeCalculator;

    public LottoPrizeVendor(Lotto winningLotto, LottoBonusNumber bonusNumber) {
        this.prizeCalculator = new LottoPrizeCalculateService(winningLotto, bonusNumber);
    }

    @Override
    public SortedMap<LottoPrize, Integer> countPrize(List<Lotto> lottoList) {
        return prizeCalculator.countPrize(lottoList);
    }

    @Override
    public double calculateProfitRate(Map<LottoPrize, Integer> prizeMap) {
        return prizeCalculator.calculateProfitRate(prizeMap);
    }

}
