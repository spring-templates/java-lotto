package lotto.model.entity.lotto.prize.stats;

import java.util.Map.Entry;
import java.util.SortedMap;
import lotto.model.entity.lotto.prize.PrizeOutputDto;

public record StatsOutputDto(
        SortedMap<PrizeOutputDto, Integer> prizeStats
) implements IStatsOutputDto {
    public static StatsOutputDto of(IStatsInputDto input) {
        return new StatsGenerator().generate(input);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (PrizeOutputDto key : prizeStats.keySet()) {
            if (key.prize().money() == 0) {
                continue;
            }
            sb.append(key);
            sb.append(" - %d개".formatted(prizeStats.get(key)));
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

    public double profitRate() {
        double netProfit = 0;
        double cost = 0;
        for (Entry<PrizeOutputDto, Integer> entry : prizeStats.entrySet()) {
            netProfit += entry.getKey().prize().money() * entry.getValue();
            cost += entry.getValue() * 1000L;
        }
        return netProfit / cost * 100;
    }
}