package lotto.model.entity.lotto.prize.stats;

import base.model.Entity;
import base.model.Generator;

public class StatsGenerator extends Generator<IStatsInputDto, StatsOutputDto> {
    @Override
    protected final Entity<IStatsInputDto, StatsOutputDto> getEntity(IStatsInputDto input) {
        return new StatsEntity(input);
    }
}
