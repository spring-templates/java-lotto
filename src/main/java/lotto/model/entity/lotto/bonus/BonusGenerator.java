package lotto.model.entity.lotto.bonus;

import base.Generator;

public class BonusGenerator extends Generator<IBonusInputDto, BonusOutputDto> {

    @Override
    public BonusOutputDto generate(IBonusInputDto input) throws IllegalArgumentException {
        return getEntity(input).toDto();
    }

    @Override
    protected BonusEntity getEntity(IBonusInputDto input) {
        return new BonusEntity(input);
    }
}
