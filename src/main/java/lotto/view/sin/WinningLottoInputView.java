package lotto.view.sin;


import base.view.InputView;
import lotto.model.entity.lotto.ILottoInputDto;

public class WinningLottoInputView extends InputView<ILottoInputDto> {
    @Override
    public void header() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }
}
