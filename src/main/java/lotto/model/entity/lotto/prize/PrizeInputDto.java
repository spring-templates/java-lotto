package lotto.model.entity.lotto.prize;

import lotto.model.entity.lotto.ILottoOutputDto;
import lotto.model.entity.lotto.WinningLottoOutputDto;
import lotto.model.entity.lotto.bonus.BonusOutputDto;

public record PrizeInputDto(
        ILottoOutputDto lotto,
        WinningLottoOutputDto winningLotto,
        BonusOutputDto bonusNumber
) implements IPrizeInputDto {
}
