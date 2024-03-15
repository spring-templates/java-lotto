package lotto.model.entity.lotto;

import java.util.List;

public record LottoPurchaseOutputDto(
        List<LottoOutputDto> purchased
) implements ILottoPurchaseOutputDto {
    public static LottoPurchaseOutputDto of(List<LottoOutputDto> input) {
        return new LottoPurchaseOutputDto(input);
    }

    @Override
    public String toString() {
        return purchased.toString();
    }
}
