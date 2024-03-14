package lotto.model.entity.lotto.prize;

import base.InputSchema;
import lotto.model.entity.lotto.ILottoOutputDto;
import lotto.model.entity.lotto.WinningLottoOutputDto;
import lotto.model.entity.lotto.bonus.BonusOutputDto;

/**
 * 패키지 외부에서의 입력을 정의하는 Schema
 */
public interface IPrizeInputDto extends InputSchema {
    ILottoOutputDto lotto();

    WinningLottoOutputDto winningLotto();

    BonusOutputDto bonusNumber();

}
