package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.model.entity.CustomerSession;
import lotto.model.entity.Lotto;
import lotto.model.entity.Money;
import lotto.model.entity.Prize;
import lotto.model.service.LottoVendor;
import lotto.model.util.ExceptionHandler;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoFactory {

    public static void run() {
        CustomerSession session = new CustomerSession();
        session.addLotto(purchaseLotto());
        OutputView.printLotto(session.purchasedLotto());
        Lotto winningLotto = inputWinningLotto();
        Integer winningBonusNumber = inputBonusNumber(winningLotto);
        Map<Prize, Integer> prizeMap = calculateLottoResults(session, winningLotto, winningBonusNumber);
        OutputView.printStatistics(prizeMap);
    }

    private static List<Lotto> purchaseLotto() {
        while (true) {
            try {
                Money money = InputView.inputLottoExpense();
                return LottoVendor.purchase(money);
            } catch (IllegalArgumentException e) {
                ExceptionHandler.handle(e);
            }
        }
    }

    private static Lotto inputWinningLotto() {
        while (true) {
            try {
                return InputView.inputWinningLotto();
            } catch (IllegalArgumentException e) {
                ExceptionHandler.handle(e);
            }
        }
    }

    private static Integer inputBonusNumber(Lotto winningLotto) {
        while (true) {
            try {
                return InputView.inputBonusNumber(winningLotto);
            } catch (IllegalArgumentException e) {
                ExceptionHandler.handle(e);
            }
        }
    }

    private static Map<Prize, Integer> calculateLottoResults(
            CustomerSession session,
            Lotto winningLotto,
            Integer winningBonusNumber
    ) {
        return LottoVendor.calculatePrize(session.purchasedLotto(), winningLotto, winningBonusNumber);
    }
}
