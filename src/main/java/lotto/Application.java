package lotto;

import base.view.OutputView;
import java.util.*;
import lotto.model.entity.lotto.*;
import lotto.model.entity.lotto.bonus.BonusOutputDto;
import lotto.model.entity.lotto.prize.*;
import lotto.model.entity.lotto.prize.stats.*;
import lotto.view.sin.*;
import lotto.view.sout.*;

public class Application {
    public static void main(String[] args) {
        new MoneyInputView();
        System.out.println(8000);

        List<LottoOutputDto> purchaseLotto = List.of(
                createLottoOutputDto(List.of(8, 21, 23, 41, 42, 43)),
                createLottoOutputDto(List.of(3, 5, 11, 16, 32, 38)),
                createLottoOutputDto(List.of(7, 11, 16, 35, 36, 44)),
                createLottoOutputDto(List.of(1, 8, 11, 31, 41, 42)),
                createLottoOutputDto(List.of(13, 14, 16, 38, 42, 45)),
                createLottoOutputDto(List.of(7, 11, 30, 40, 42, 43)),
                createLottoOutputDto(List.of(2, 13, 22, 32, 38, 45)),
                createLottoOutputDto(List.of(1, 3, 5, 14, 22, 45)));

        LottoPurchaseOutputDto input = new LottoPurchaseOutputDto(purchaseLotto);
        OutputView<LottoPurchaseOutputDto> view = new LottoPurchaseOutputView();
        view.render(input);

        new WinningLottoInputView();
        System.out.println("1,2,3,4,5,6");
        WinningLottoOutputDto winningLotto = new WinningLottoOutputDto(new TreeSet<>(List.of(1, 2, 3, 4, 5, 6)));

        new WinningBonusInputView();
        System.out.println(7);
        BonusOutputDto bonus = new BonusOutputDto(7);

        PrizeStatisticsOutputView prizeStatisticsOutputView = new PrizeStatisticsOutputView();
        var prizeGenerator = new PrizeGenerator();
        List<PrizeOutputDto> prizes = new ArrayList<>();
        for (var lotto : purchaseLotto) {
            prizes.add(prizeGenerator.generate(new PrizeInputDto(lotto, winningLotto, bonus)));
        }

        var statsGenerator = new StatsGenerator();
        var statsOutput = statsGenerator.generate(new StatsInputDto(prizes));
        prizeStatisticsOutputView.render(statsOutput);
    }

    private static LottoOutputDto createLottoOutputDto(List<Integer> numbers) {
        return new LottoOutputDto(new TreeSet<>(numbers));
    }
}
