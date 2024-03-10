package lotto.view.input;

import lotto.model.entity.Lotto;
import lotto.model.entity.Lotto.LottoBonusNumber;
import lotto.model.entity.Money;

public interface IInputView {
    Money inputLottoExpense();

    Lotto inputWinningLotto();

    LottoBonusNumber inputBonusNumber(Lotto lotto);
}
