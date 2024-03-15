package lotto;

import java.util.List;
import lotto.model.entity.lotto.LottoInputDto;
import lotto.model.entity.lotto.LottoOutputDto;
import lotto.model.entity.lotto.LottoPurchaseOutputDto;
import lotto.model.entity.lotto.WinningLottoOutputDto;
import lotto.model.entity.lotto.bonus.BonusOutputDto;
import lotto.model.entity.lotto.prize.PrizeInputDto;
import lotto.model.entity.lotto.prize.PrizeOutputDto;
import lotto.model.entity.lotto.prize.stats.StatsInputDto;
import lotto.model.entity.lotto.prize.stats.StatsOutputDto;
import lotto.view.sin.MoneyInputView;
import lotto.view.sin.WinningBonusInputView;
import lotto.view.sin.WinningLottoInputView;
import lotto.view.sout.LottoPurchaseOutputView;
import lotto.view.sout.PrizeStatisticsOutputView;

public class Application {
    public static void main(String[] args) {
        args = args.length < 3 ? new String[]{"8000", "1,2,3,4,5,6", "7"} : args;
        // System.setIn(new java.io.ByteArrayInputStream(String.join(System.lineSeparator(), args).getBytes());

        new MoneyInputView().header();
        System.out.println(args[0]);
        System.out.println();

        List<List<Integer>> numbers = List.of(
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45));
        List<LottoOutputDto> purchaseLotto = numbers.stream()
                .map(LottoInputDto::of)
                .map(LottoOutputDto::of)
                .toList();

        LottoPurchaseOutputDto input = new LottoPurchaseOutputDto(purchaseLotto);
        var view = new LottoPurchaseOutputView();
        view.render(input);

        System.out.println();
        new WinningLottoInputView().header();
        System.out.println(args[1]);
        System.out.println();
        WinningLottoOutputDto winningLotto = WinningLottoOutputDto.of(LottoInputDto.of(List.of(1, 2, 3, 4, 5, 6)));

        new WinningBonusInputView().header();
        System.out.println(args[2]);
        System.out.println();
        BonusOutputDto bonus = new BonusOutputDto(7);

        var prizeStatisticsOutputView = new PrizeStatisticsOutputView();
        List<PrizeOutputDto> prizes = purchaseLotto
                .stream()
                .map(lotto -> new PrizeInputDto(lotto, winningLotto, bonus))
                .map(PrizeOutputDto::of)
                .toList();

        StatsOutputDto stats = StatsOutputDto.of(StatsInputDto.of(prizes));
        prizeStatisticsOutputView.render(stats);
    }
}
