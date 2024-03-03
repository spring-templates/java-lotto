package lotto.model.service;

import java.util.List;
import java.util.Map;
import lotto.model.entity.Lotto;
import lotto.model.entity.Money;
import lotto.model.entity.Prize;

public class LottoVendor {
    public static final Money lottoPrice = new Money("원", 1000);

    public static List<Lotto> purchase(Money money) throws IllegalArgumentException {
        return new LottoGenerateService(lottoPrice).purchaseMultipleLotto(money);
    }

    public static Map<Prize, Integer> calculatePrize(List<Lotto> lottoList, Lotto winningLotto,
                                                     Integer winningBonusNumber) {
        return new LottoPrizeCalculateService(winningLotto, winningBonusNumber).calculatePrize(lottoList);
    }
}
