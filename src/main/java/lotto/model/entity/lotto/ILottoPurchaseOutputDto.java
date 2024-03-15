package lotto.model.entity.lotto;

import base.OutputSchema;
import java.util.List;

public interface ILottoPurchaseOutputDto extends OutputSchema {
    List<LottoOutputDto> purchased();
}
