package lotto.model.entity.lotto;

import java.util.List;

public record LottoInputDto(
        List<Integer> numbers
) implements ILottoInputDto {
}
