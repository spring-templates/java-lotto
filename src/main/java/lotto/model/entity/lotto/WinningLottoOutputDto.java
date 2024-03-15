package lotto.model.entity.lotto;

import java.util.SortedSet;

public record WinningLottoOutputDto(SortedSet<Integer> numbers) implements ILottoOutputDto {
    public static WinningLottoOutputDto of(ILottoInputDto input) {
        LottoOutputDto a = new LottoGenerator().generate(input);
        return new WinningLottoOutputDto(a.numbers());
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public Integer countNumberMatched(ILottoOutputDto lotto) {
        int count = 0;
        for (Integer number : numbers) {
            count += lotto.numbers().contains(number) ? 1 : 0;
        }
        return count;
    }
}
