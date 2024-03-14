package lotto.view.sin;


import base.view.InputView;
import lotto.model.entity.money.IMoneyInputDto;

public class MoneyInputView extends InputView<IMoneyInputDto> {
    @Override
    public void header() {
        System.out.println("구입금액을 입력해 주세요.");
    }
}
