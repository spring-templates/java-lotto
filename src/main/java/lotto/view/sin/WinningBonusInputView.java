package lotto.view.sin;

import base.view.InputView;
import lotto.model.entity.lotto.bonus.IBonusInputDto;

public class WinningBonusInputView extends InputView<IBonusInputDto> {
    @Override
    public void header() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }
}
