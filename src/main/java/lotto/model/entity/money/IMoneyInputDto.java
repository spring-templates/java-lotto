package lotto.model.entity.money;

import base.InputSchema;

/**
 * 패키지 외부에서의 입력을 정의하는 Schema
 */
public interface IMoneyInputDto extends InputSchema {
    Integer money();
}
