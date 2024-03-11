package lotto.model.vendor.prize;

import java.util.*;
import lotto.model.entity.Priced;

public interface IPrizeVendor<Product extends Priced, Prize extends Priced> {
    SortedMap<Prize, Integer> countPrize(List<Product> lottoList);

    double calculateProfitRate(Map<Prize, Integer> prizeMap);
}
