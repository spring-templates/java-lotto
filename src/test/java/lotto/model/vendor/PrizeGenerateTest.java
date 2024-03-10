package lotto.model.vendor;

import java.util.List;
import java.util.Map;
import lotto.model.entity.Lotto;
import lotto.model.entity.Lotto.LottoBonusNumber;
import lotto.model.literal.LottoPrize;
import lotto.model.vendor.prize.LottoPrizeVendor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeGenerateTest {
    Lotto winningLotto;
    LottoBonusNumber winningBonusNumber;
    List<Lotto> purchasedLotto;

    @BeforeEach
    void setUp() {
        winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        winningBonusNumber = new LottoBonusNumber(winningLotto, 7);
        purchasedLotto = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 45)),
                new Lotto(List.of(1, 2, 3, 4, 44, 45)),
                new Lotto(List.of(1, 2, 3, 43, 44, 45))
        );
    }

    @DisplayName("각 당첨 등수별 당첨 개수를 계산한다")
    @Test
    void calculatePrize() {
        LottoPrizeVendor lottoPrizeVendor = new LottoPrizeVendor(winningLotto, winningBonusNumber);
        Map<LottoPrize, Integer> prizeCounter = lottoPrizeVendor.countPrize(purchasedLotto);

        Assertions.assertThat(prizeCounter.get(LottoPrize.FIFTH)).isEqualTo(1);
        Assertions.assertThat(prizeCounter.get(LottoPrize.FOURTH)).isEqualTo(1);
        Assertions.assertThat(prizeCounter.get(LottoPrize.THIRD)).isEqualTo(1);
        Assertions.assertThat(prizeCounter.get(LottoPrize.SECOND)).isEqualTo(1);
        Assertions.assertThat(prizeCounter.get(LottoPrize.FIRST)).isEqualTo(1);
    }
}