package lotto.model.entity.lotto;

import base.model.Entity;
import base.model.Generator;

public class LottoGenerator extends Generator<ILottoInputDto, LottoOutputDto> {

    @Override
    public LottoOutputDto generate(ILottoInputDto input) throws IllegalArgumentException {
        return getEntity(input).toDto();
    }

    @Override
    protected final Entity<ILottoInputDto, LottoOutputDto> getEntity(ILottoInputDto input) {
        return new LottoEntity(input);
    }
}
