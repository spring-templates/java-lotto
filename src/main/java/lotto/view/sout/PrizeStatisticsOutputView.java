package lotto.view.sout;

import base.view.OutputView;
import lotto.model.entity.lotto.prize.stats.StatsOutputDto;

public class PrizeStatisticsOutputView extends OutputView<StatsOutputDto> {

    public void render(StatsOutputDto prizeStatsOutputDto) {
        System.out.println(prizeStatsOutputDto);
        printProfitRate(prizeStatsOutputDto);
    }

    @Override
    protected void header() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    private void printProfitRate(StatsOutputDto prizeStatsOutputDto) {
        System.out.println("총 수익률은 " + prizeStatsOutputDto.profitRate() + "%입니다.");
    }
}
