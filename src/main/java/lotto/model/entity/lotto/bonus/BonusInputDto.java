package lotto.model.entity.lotto.bonus;

import lotto.model.entity.lotto.ILottoOutputDto;

public record BonusInputDto(
        ILottoOutputDto lotto,
        Integer bonusNumber
) implements IBonusInputDto {
    @Override
    public String toString() {
        return bonusNumber.toString();
    }
}
