package lotto;

import java.io.ByteArrayInputStream;
import lotto.controller.MoneyConsoleInput;
import lotto.controller.MoneyToPurchaseLotto;
import lotto.controller.PurchaseLottoToPrize;
import lotto.controller.WinningBonusConsoleInput;
import lotto.controller.WinningLottoConsoleInput;
import lotto.model.bonus.BonusOutputDto;
import lotto.model.bonus.IBonusOutput;
import lotto.model.lotto.winning.IWinningLottoOutput;
import lotto.model.money.IMoneyInput;

public class Application {

    public static void main(String[] args) {
        if (args.length < 3) {
            args = new String[]{"8000", "1,2,3,4,5,6", "7"};
        }
        ByteArrayInputStream actual = new ByteArrayInputStream(
                String.join(System.lineSeparator(), args).getBytes());
        System.setIn(actual);

        // 구입 금액 입력
        IMoneyInput money;
        try (var console = MoneyConsoleInput.of()) {
            money = console.getInput();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 로또 구매
        var purchasedLotto = MoneyToPurchaseLotto.of().tryConvert(money);

        // 당첨 로또 번호 입력
        IWinningLottoOutput winningLotto;
        try (var console = WinningLottoConsoleInput.of()) {
            winningLotto = IWinningLottoOutput.of(console.getInput());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 보너스 번호 입력
        IBonusOutput bonusNumber;
        try (var console = WinningBonusConsoleInput.of(winningLotto)) {
            bonusNumber = BonusOutputDto.of(console.getInput());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 당첨 통계 출력
        PurchaseLottoToPrize.of(winningLotto, bonusNumber).tryConvert(purchasedLotto);
    }
}
