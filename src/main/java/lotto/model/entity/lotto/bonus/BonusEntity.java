package lotto.model.entity.lotto.bonus;

import base.model.Entity;
import lotto.model.entity.lotto.ILottoOutputDto;

final class BonusEntity extends Entity<IBonusInputDto, BonusOutputDto> implements IBonusOutputDto {
    private final Bonus lotto;

    public BonusEntity(IBonusInputDto input) throws IllegalArgumentException {
        super(input, new BonusModelValidator());
        this.lotto = new Bonus(input.lotto(), input.bonusNumber());
        modelValidator.validate(toDto());
    }

    @Override
    public BonusOutputDto toDto() {
        return new BonusOutputDto(bonusNumber());
    }

    @Override
    public Integer bonusNumber() {
        return lotto.bonusNumber();
    }

    private record Bonus(
            ILottoOutputDto lotto,
            Integer bonusNumber
    ) implements IBonusInputDto {
    }
}
