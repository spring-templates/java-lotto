package lotto.controller;

import base.controller.Converter;
import base.view.View;
import lotto.model.bonus.BonusOutputDto;
import lotto.model.lotto.ILottoPurchaseOutput;
import lotto.model.lotto.winning.WinningLottoOutputDto;
import lotto.model.prize.IPrizeOutput;
import lotto.model.prize.PrizeEnum;
import lotto.model.prize.PrizeOutputDto;
import lotto.model.stats.IStatsOutput;
import lotto.model.stats.StatsInputDto;
import lotto.model.stats.StatsOutputDto;

public class PurchaseLottoToPrize extends Converter<ILottoPurchaseOutput, IStatsOutput> {

    private final WinningLottoOutputDto winningLotto;
    private final BonusOutputDto winningBonusNumber;

    public PurchaseLottoToPrize(View<IStatsOutput> view, WinningLottoOutputDto winningLotto,
                                BonusOutputDto winningBonusNumber) {
        super(view);
        this.winningLotto = winningLotto;
        this.winningBonusNumber = winningBonusNumber;
    }

    @Override
    protected IStatsOutput convert(ILottoPurchaseOutput input) {
        var tmp = input.purchased().stream().map(e -> PrizeOutputDto.of(
                        PrizeEnum.of(winningLotto.countNumberMatched(e), winningBonusNumber.isBonusMatched(e))))
                .map(e -> (IPrizeOutput) e).toList();
        return StatsOutputDto.of(StatsInputDto.of(tmp));
    }
}
