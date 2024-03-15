package lotto.model.entity.lotto.prize.stats;

import base.InputSchema;
import java.util.List;
import lotto.model.entity.lotto.prize.PrizeOutputDto;

/**
 * 패키지 외부에서의 입력을 정의하는 Schema
 */
public interface IStatsInputDto extends InputSchema {
    List<PrizeOutputDto> purchasedLotto();
}
