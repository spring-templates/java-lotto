package lotto.model.entity.lotto;

import java.util.SortedSet;

public record LottoOutputDto(
        SortedSet<Integer> numbers
) implements ILottoOutputDto {
    @Override
    public String toString() {
        return numbers.toString();
    }
}

