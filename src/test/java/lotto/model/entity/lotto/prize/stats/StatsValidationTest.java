package lotto.model.entity.lotto.prize.stats;

import java.util.List;
import lotto.model.entity.lotto.prize.PrizeEnum;
import lotto.model.entity.lotto.prize.PrizeOutputDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StatsValidationTest {

    @DisplayName("calculate profit rate")
    @Test
    void calculateProfitRate() {
        // given
        List<PrizeOutputDto> prizes = List.of(
            PrizeOutputDto.of(PrizeEnum.FIRST),
            PrizeOutputDto.of(PrizeEnum.SECOND),
            PrizeOutputDto.of(PrizeEnum.THIRD),
            PrizeOutputDto.of(PrizeEnum.FOURTH),
            PrizeOutputDto.of(PrizeEnum.FIFTH),
            PrizeOutputDto.of(PrizeEnum.NONE_0)
        );
        double expected = calculateProfitRate(prizes);

        // when
        double actual = StatsOutputDto.of(StatsInputDto.of(prizes)).profitRate();

        // then
        Assertions.assertEquals(expected, actual);
    }

    private double calculateProfitRate(List<PrizeOutputDto> prizes) {
        double profit = 0;
        double cost = 0;
        for (PrizeOutputDto prize : prizes) {
            profit += prize.prize().money();
            cost += 1000;
        }
        return profit / cost * 100;
    }
}
