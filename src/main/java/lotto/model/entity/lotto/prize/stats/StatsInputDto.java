package lotto.model.entity.lotto.prize.stats;

import java.util.List;
import lotto.model.entity.lotto.prize.PrizeOutputDto;

public record StatsInputDto(
        List<PrizeOutputDto> purchasedLotto
) implements IStatsInputDto {
}
