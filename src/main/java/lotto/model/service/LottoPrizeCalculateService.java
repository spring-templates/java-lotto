package lotto.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import lotto.model.entity.Lotto;
import lotto.model.entity.Prize;

class LottoPrizeCalculateService {
    private final Lotto winningLotto;
    private final Integer winningBonusNumber;


    LottoPrizeCalculateService(Lotto winningLotto, Integer winningBonusNumber) {
        this.winningLotto = winningLotto;
        this.winningBonusNumber = winningBonusNumber;
    }

    Map<Prize, Integer> calculatePrize(List<Lotto> lottoList) {
        Map<Prize, Integer> prizeCounter = new HashMap<>();

        // 초기화
        prizeCounter.put(new Prize(5, true), 0);
        for (int i = 3; i <= 6; i++) {
            Prize prize = new Prize(i, false);
            prizeCounter.put(prize, 0);
        }

        for (Lotto lotto : lottoList) {
            Prize prize = convertLottoToPrize(lotto);
            prizeCounter.put(prize, prizeCounter.getOrDefault(prize, 0) + 1);
        }
        return prizeCounter;
    }

    private Prize convertLottoToPrize(Lotto lotto) {
        int matchCount = countMatchingNumbers(lotto);
        boolean bonusMatch = false;
        if (matchCount == 5) {
            bonusMatch = isBonusMatched(lotto);
        }
        return new Prize(matchCount, bonusMatch);
    }

    private int countMatchingNumbers(Lotto lotto) {
        SortedSet<Integer> winningNumbers = winningLotto.numbers();
        SortedSet<Integer> numbers = lotto.numbers();
        return (int) numbers.stream().filter(winningNumbers::contains).count();
    }

    private boolean isBonusMatched(Lotto lotto) {
        return lotto.numbers().contains(winningBonusNumber);
    }
}
