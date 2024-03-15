package lotto.model.entity.lotto;

import java.util.List;

public record LottoPurchaseOutputDto(
        List<LottoOutputDto> purchased
) implements ILottoPurchaseOutputDto {
    @Override
    public String toString() {
        return purchased.toString();
    }
}
