package lotto.model.entity.lotto.bonus;

import base.model.Entity;
import base.model.Generator;

public class BonusGenerator extends Generator<IBonusInputDto, BonusOutputDto> {

    @Override
    public BonusOutputDto generate(IBonusInputDto input) throws IllegalArgumentException {
        return getEntity(input).toDto();
    }

    @Override
    protected final Entity<IBonusInputDto, BonusOutputDto> getEntity(IBonusInputDto input) {
        return new BonusEntity(input);
    }
}
