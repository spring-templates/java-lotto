package lotto.model.entity.lotto.prize.stats;

import base.OutputSchema;
import java.util.SortedMap;
import lotto.model.entity.lotto.prize.PrizeOutputDto;

/**
 * 패키지 외부로 전달되는 출력을 정의하는 Schema
 */
public interface IStatsOutputDto extends OutputSchema {
    SortedMap<PrizeOutputDto, Integer> prizeStats();
}