package lotto.model.entity.lotto.prize;

import base.model.Entity;
import base.model.Generator;

public class PrizeGenerator extends Generator<IPrizeInputDto, PrizeOutputDto> {
    @Override
    protected final Entity<IPrizeInputDto, PrizeOutputDto> getEntity(IPrizeInputDto input) {
        return new PrizeEntity(input);
    }
}
