package lotto.model.entity.lotto;

import java.util.SortedSet;

public record LottoOutputDto(SortedSet<Integer> numbers) implements ILottoOutputDto {
    public static LottoOutputDto of(ILottoInputDto input) {
        return new LottoGenerator().generate(input);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
