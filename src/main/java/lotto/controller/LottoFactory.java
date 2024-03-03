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
        Lotto winningLotto = InputView.inputWinningLotto();
        Integer winningBonusNumber = InputView.inputBonusNumber(winningLotto);
        Map<Prize, Integer> prizeMap = calculateLottoResults(session, winningLotto, winningBonusNumber);
        OutputView.printStatistics(LottoVendor.lottoPrice.amount(), prizeMap);
    }

    protected static List<Lotto> purchaseLotto() {
        while (true) {
            try {
                Money money = InputView.inputLottoExpense();
                return LottoVendor.purchase(money);
            } catch (IllegalArgumentException e) {
                ExceptionHandler.handle(e);
            }
        }
    }

    protected static Map<Prize, Integer> calculateLottoResults(
            CustomerSession session,
            Lotto winningLotto,
            Integer winningBonusNumber
    ) {
        return LottoVendor.calculatePrize(session.purchasedLotto(), winningLotto, winningBonusNumber);
    }
}
