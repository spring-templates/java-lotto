package lotto.model.entity.lotto;

import base.model.Entity;
import base.model.Generator;

public class LottoGenerator extends Generator<ILottoInputDto, LottoOutputDto> {
    @Override
    protected final Entity<ILottoInputDto, LottoOutputDto> getEntity(ILottoInputDto input) {
        return new LottoEntity(input);
    }
}
