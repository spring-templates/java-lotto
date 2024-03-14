package lotto.model.entity.lotto;

import base.Generator;

public class LottoGenerator extends Generator<ILottoInputDto, LottoOutputDto> {

    @Override
    public LottoOutputDto generate(ILottoInputDto input) throws IllegalArgumentException {
        return getEntity(input).toDto();
    }

    @Override
    protected LottoEntity getEntity(ILottoInputDto input) {
        return new LottoEntity(input);
    }
}
