package lotto.model.entity.lotto.prize;

import base.Generator;

public class PrizeGenerator extends Generator<IPrizeInputDto, PrizeOutputDto> {

    @Override
    public PrizeOutputDto generate(IPrizeInputDto input) throws IllegalArgumentException {
        return getEntity(input).toDto();
    }

    @Override
    protected final PrizeEntity getEntity(IPrizeInputDto input) {
        return new PrizeEntity(input);
    }
}
