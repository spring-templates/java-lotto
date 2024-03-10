package lotto.model.vendor.prize;

import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import lotto.model.entity.Priced;

public interface IPrizeVendor<Product extends Priced, Prize extends Priced> {
    SortedMap<Prize, Integer> countPrize(List<Product> lottoList);

    double calculateProfitRate(Map<Prize, Integer> prizeMap);
}
