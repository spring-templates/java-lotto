package lotto.model.entity.lotto;

import java.util.List;
import base.InputSchema;

/**
 * 패키지 외부에서의 입력을 정의하는 Schema
 */
public interface ILottoInputDto extends InputSchema {
    List<Integer> numbers();
}
