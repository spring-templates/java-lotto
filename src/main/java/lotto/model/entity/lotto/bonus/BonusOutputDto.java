package lotto.model.entity.lotto.bonus;

import lotto.model.entity.lotto.ILottoOutputDto;

public record BonusOutputDto(
        Integer bonusNumber
) implements IBonusOutputDto {
    @Override
    public String toString() {
        return bonusNumber.toString();
    }

    public Boolean isBonusMatched(ILottoOutputDto bonus) {
        return bonus.numbers().contains(bonusNumber);
    }
}
