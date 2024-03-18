package lotto.model.bonus;

import lotto.model.lotto.ILottoOutput;

public record BonusOutputDto(int bonusNumber) implements IBonusOutput {
    @Override
    public String toString() {
        return Integer.toString(bonusNumber);
    }

    public Boolean isBonusMatched(ILottoOutput bonus) {
        return bonus.numbers().contains(bonusNumber);
    }
}
