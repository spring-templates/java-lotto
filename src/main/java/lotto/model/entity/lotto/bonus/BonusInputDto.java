package lotto.model.entity.lotto.bonus;

import java.util.SortedSet;

public record BonusInputDto(
        SortedSet<Integer> numbers,
        Integer bonusNumber
) implements IBonusInputDto {
    @Override
    public String toString() {
        return bonusNumber.toString();
    }
}
