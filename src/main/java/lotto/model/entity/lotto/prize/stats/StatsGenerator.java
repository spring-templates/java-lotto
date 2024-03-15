package lotto.model.entity.lotto.prize.stats;

import base.model.Entity;
import base.model.Generator;

public class StatsGenerator extends Generator<IStatsInputDto, StatsOutputDto> {

    @Override
    public StatsOutputDto generate(IStatsInputDto input) throws IllegalArgumentException {
        return getEntity(input).toDto();
    }

    @Override
    protected final Entity<IStatsInputDto, StatsOutputDto> getEntity(IStatsInputDto input) {
        return new StatsEntity(input);
    }
}
