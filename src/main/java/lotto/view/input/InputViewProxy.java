package lotto.view.input;

import lotto.model.entity.Lotto;
import lotto.model.entity.Lotto.LottoBonusNumber;
import lotto.model.entity.Money;

public class InputViewProxy implements IInputView {

    private final InputViewImpl inputView;

    public InputViewProxy() {
        this.inputView = new InputViewImpl();
    }

    @Override
    public Money inputLottoExpense() {
        return inputView.inputLottoExpense();
    }

    @Override
    public Lotto inputWinningLotto() {
        return inputView.inputWinningLotto();
    }

    @Override
    public LottoBonusNumber inputBonusNumber(Lotto lotto) {
        return inputView.inputBonusNumber(lotto);
    }
}
