package lotto.model.entity.lotto.prize.stats;

import java.util.List;
import lotto.model.entity.lotto.prize.PrizeOutputDto;

public record StatsInputDto(
        List<PrizeOutputDto> purchasedLotto
) implements IStatsInputDto {
    public static StatsInputDto of(List<PrizeOutputDto> input) {
        return new StatsInputDto(input);
    }
}
