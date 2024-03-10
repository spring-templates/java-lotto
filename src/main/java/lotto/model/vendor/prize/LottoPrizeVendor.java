package lotto.model.vendor.prize;

import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import lotto.model.entity.Lotto;
import lotto.model.entity.Lotto.LottoBonusNumber;
import lotto.model.literal.LottoPrize;
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
