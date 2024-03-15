package lotto.model.entity.lotto.bonus;

import lotto.model.entity.lotto.ILottoOutputDto;

public record BonusOutputDto(
        Integer bonusNumber
) implements IBonusOutputDto {
    public static BonusOutputDto of(IBonusInputDto input) {
        return new BonusGenerator().generate(input);
    }

    @Override
    public String toString() {
        return bonusNumber.toString();
    }

    public Boolean isBonusMatched(ILottoOutputDto bonus) {
        return bonus.numbers().contains(bonusNumber);
    }
}
