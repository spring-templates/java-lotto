package lotto;

import java.util.List;
import java.util.Map;
import lotto.model.entity.Lotto;
import lotto.model.entity.Prize;
import lotto.model.service.LottoVendor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeTest {

    private Lotto winningLotto;
    private int winningBonusNumber;
    private List<Lotto> purchasedLottos;


    @DisplayName("각 당첨 등수별 당첨 개수를 계산한다")
    @Test
    void calculatePrize() {
        winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        winningBonusNumber = 7;
        purchasedLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 45)),
                new Lotto(List.of(1, 2, 3, 4, 44, 45)),
                new Lotto(List.of(1, 2, 3, 43, 44, 45))
        );

        Map<Prize, Integer> prizeCounter = LottoVendor.calculatePrize(purchasedLottos, winningLotto,
                winningBonusNumber);

        Assertions.assertThat(prizeCounter.get(new Prize(3, false))).isEqualTo(1);
        Assertions.assertThat(prizeCounter.get(new Prize(4, false))).isEqualTo(1);
        Assertions.assertThat(prizeCounter.get(new Prize(5, false))).isEqualTo(1);
        Assertions.assertThat(prizeCounter.get(new Prize(5, true))).isEqualTo(1);
        Assertions.assertThat(prizeCounter.get(new Prize(6, false))).isEqualTo(1);
    }
}