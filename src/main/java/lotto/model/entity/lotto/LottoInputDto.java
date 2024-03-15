package lotto.model.entity.lotto;

import java.util.List;

public record LottoInputDto(
        List<Integer> numbers
) implements ILottoInputDto {
    public static LottoInputDto of(List<Integer> numbers) {
        return new LottoInputDto(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
