package lotto.model.entity.money;

import base.OutputSchema;

/**
 * 패키지 외부로 전달되는 출력을 정의하는 Schema
 */
public interface IMoneyOutputDto extends OutputSchema {
    Integer money();
}
