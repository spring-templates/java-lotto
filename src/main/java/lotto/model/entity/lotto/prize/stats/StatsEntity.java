package lotto.model.entity.lotto.prize.stats;

import base.model.Entity;
import java.util.SortedMap;
import java.util.TreeMap;
import lotto.model.entity.lotto.prize.PrizeEnum;
import lotto.model.entity.lotto.prize.PrizeOutputDto;

final class StatsEntity extends Entity<IStatsInputDto, StatsOutputDto> implements
        IStatsOutputDto {
    private final Stats stats;

    public StatsEntity(IStatsInputDto input) throws IllegalArgumentException {
        super(input, new StatsModelValidator());
        this.stats = statsFactory(input);
        modelValidator.validate(toDto());
    }

    private Stats statsFactory(IStatsInputDto input) {
        SortedMap<PrizeOutputDto, Integer> res = new TreeMap<>();
        for (var key : PrizeEnum.values()) {
            res.put(PrizeOutputDto.of(key), 0);
        }
        for (var prize : input.purchasedLotto()) {
            res.put(prize, res.get(prize) + 1);
        }
        return new Stats(res);
    }

    @Override
    public StatsOutputDto toDto() {
        return new StatsOutputDto(prizeStats());
    }

    @Override
    public SortedMap<PrizeOutputDto, Integer> prizeStats() {
        return stats.prizeStats;
    }

    private record Stats(
            SortedMap<PrizeOutputDto, Integer> prizeStats
    ) implements IStatsOutputDto {
    }
}
