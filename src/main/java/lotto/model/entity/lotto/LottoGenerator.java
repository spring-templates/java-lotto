package lotto.model.entity.lotto;

import base.Entity;
import base.Generator;
public class LottoGenerator extends Generator<ILottoInputDto, ILottoOutputDto> {
    @Override
    public ILottoOutputDto generate(ILottoInputDto iLottoInput) throws IllegalArgumentException {
        LottoEntity entity = new LottoEntity(iLottoInput);
        return entity.toDto();
    }

    @Override
    protected Entity<ILottoInputDto, ILottoOutputDto> getEntity(ILottoInputDto iLottoInputDto) {
        return null;
    }

}
