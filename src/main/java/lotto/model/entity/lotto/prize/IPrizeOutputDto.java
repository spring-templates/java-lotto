package lotto.model.entity.lotto.prize;

import base.OutputSchema;
import lotto.model.entity.money.IMoneyOutputDto;

/**
 * 패키지 외부로 전달되는 출력을 정의하는 Schema
 */
public interface IPrizeOutputDto extends OutputSchema {
    Integer matchedNumberCount();

    Boolean isBonusMatched();

    IMoneyOutputDto prize();
}
