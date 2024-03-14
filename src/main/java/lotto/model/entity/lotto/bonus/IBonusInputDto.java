package lotto.model.entity.lotto.bonus;

import base.InputSchema;
import lotto.model.entity.lotto.ILottoOutputDto;

/**
 * 패키지 외부에서의 입력을 정의하는 Schema
 */
public interface IBonusInputDto extends InputSchema, ILottoOutputDto {
    Integer bonusNumber();
}
