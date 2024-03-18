package lotto;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import lotto.controller.MoneyConsoleInput;
import lotto.controller.MoneyToPurchaseLotto;
import lotto.controller.PurchaseLottoToPrize;
import lotto.controller.WinningBonusConsoleInput;
import lotto.controller.WinningLottoConsoleInput;
import lotto.model.bonus.BonusInputValidator;
import lotto.model.bonus.BonusOutputDto;
import lotto.model.lotto.winning.IWinningLottoInput;
import lotto.model.lotto.winning.WinningLottoInputValidator;
import lotto.model.lotto.winning.WinningLottoOutputDto;
import lotto.model.money.LottoCostInputValidator;
import lotto.view.sin.BonusInputView;
import lotto.view.sin.MoneyInputView;
import lotto.view.sin.WinningLottoInputView;
import lotto.view.sout.LottoPurchaseOutputView;
import lotto.view.sout.PrizeStatisticsOutputView;

public class Application {

    private static void lineFeed() {
        System.out.println();
    }

    public static void main(String[] args) {
        boolean isTest = args.length == 3;
        if (isTest) {
            var arguments = Arrays.asList(args);
            String input = String.join(System.lineSeparator(), arguments);
            System.setIn(new ByteArrayInputStream(input.getBytes()));
        }
        lineFeed();
        // 구입 금액 입력
        var money = new MoneyConsoleInput(new MoneyInputView(), new LottoCostInputValidator()).getInput();
        if (isTest) {
            System.out.println(args[0]);
        }
        // 로또 구매
        var purchasedLotto = new MoneyToPurchaseLotto(new LottoPurchaseOutputView()).tryConvert(money);
        // 당첨 로또 번호 입력
        IWinningLottoInput winningLotto = new WinningLottoConsoleInput(new WinningLottoInputView(),
                new WinningLottoInputValidator()).getInput();
        if (isTest) {
            System.out.println(args[1]);
        }
        // 보너스 번호 입력
        var bonusNumber = new WinningBonusConsoleInput(new BonusInputView(), new BonusInputValidator(),
                WinningLottoOutputDto.of(winningLotto)).getInput().bonusNumber();
        if (isTest) {
            System.out.println(args[2]);
        }
        // 당첨 통계 출력
        new PurchaseLottoToPrize(new PrizeStatisticsOutputView(), WinningLottoOutputDto.of(winningLotto),
                new BonusOutputDto(bonusNumber)).tryConvert(purchasedLotto);
    }
}
