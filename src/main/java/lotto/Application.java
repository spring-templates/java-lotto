package lotto;

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

        new WinningLottoInputView();
        System.out.println("1,2,3,4,5,6");
        WinningLottoOutputDto winningLotto = WinningLottoOutputDto.of(LottoInputDto.of(List.of(1,2,3,4,5,6)));

        new WinningBonusInputView();
        System.out.println(7);
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
