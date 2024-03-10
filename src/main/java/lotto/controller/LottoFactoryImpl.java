package lotto.controller;

import java.util.List;
import lotto.model.entity.Lotto;
import lotto.model.entity.Lotto.LottoBonusNumber;
import lotto.model.entity.Money;
import lotto.model.vendor.IVendor;
import lotto.model.vendor.prize.LottoPrizeVendor;
import lotto.util.ExceptionHandler;
import lotto.view.input.IInputView;
import lotto.view.input.InputViewProxy;

class LottoFactoryImpl implements ILottoFactory {

    private final IInputView inputView;

    LottoFactoryImpl() {
        inputView = new InputViewProxy();
    }

    public List<Lotto> purchaseLotto(IVendor<Lotto> vendor) {
        while (true) {
            try {
                Money money = inputView.inputLottoExpense();
                return vendor.purchase(money);
            } catch (IllegalArgumentException e) {
                System.out.println(ExceptionHandler.handle(e));
            }
        }
    }


    public LottoPrizeVendor inputPrizeVendor() {
        Lotto winningLotto = inputWinningLotto();
        LottoBonusNumber bonusNumber;
        do {
            bonusNumber = inputBonusNumber(winningLotto);
        } while (winningLotto.contains(bonusNumber));

        return new LottoPrizeVendor(winningLotto, bonusNumber);
    }

    public Lotto inputWinningLotto() {
        while (true) {
            try {
                return inputView.inputWinningLotto();
            } catch (IllegalArgumentException e) {
                System.out.println(ExceptionHandler.handle(e));
            }
        }
    }

    public LottoBonusNumber inputBonusNumber(Lotto lotto) {
        while (true) {
            try {
                return inputView.inputBonusNumber(lotto);
            } catch (IllegalArgumentException e) {
                System.out.println(ExceptionHandler.handle(e));
            }
        }
    }
}
