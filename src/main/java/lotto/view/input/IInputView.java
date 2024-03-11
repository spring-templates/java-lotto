package lotto.view.input;

import lotto.model.entity.*;

public interface IInputView {
    Money inputLottoExpense();

    Lotto inputWinningLotto();

    LottoBonusNumber inputBonusNumber(Lotto lotto);
}
