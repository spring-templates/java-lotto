package lotto.model.lotto.winning;

import java.util.SortedSet;
import java.util.TreeSet;
import lotto.model.lotto.ILottoInput;
import lotto.model.lotto.ILottoOutput;

public record WinningLottoOutputDto(
        SortedSet<Integer> numbers
) implements IWinningLottoOutput {
    public static WinningLottoOutputDto of(ILottoInput input) throws IllegalArgumentException {
        var tmp = new WinningLottoOutputDto(new TreeSet<>(input.numbers()));
        new LottoOutputValidator().validate(tmp);
        return tmp;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public Integer countNumberMatched(ILottoOutput lotto) {
        int count = 0;
        for (Integer number : numbers) {
            count += lotto.numbers().contains(number) ? 1 : 0;
        }
        return count;
    }
}
