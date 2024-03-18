package lotto.model.prize;

import java.text.DecimalFormat;

public record PrizeOutputDto(
        int matchedNumberCount,
        boolean isBonusMatched,
        int money

) implements IPrizeOutput, Comparable<IPrizeOutput> {
    public static PrizeOutputDto of(PrizeEnum prizeEnum) {
        return new PrizeOutputDto(
                prizeEnum.getCountMatched(),
                prizeEnum.getIsBonusMatched(),
                prizeEnum.getPrize()
        );
    }

    @Override
    public String toString() {
        String matchCountMessage = "%d개 일치".formatted(matchedNumberCount);
        String bonusMatchMessage = ", 보너스 볼 일치";
        String prizeMessage = " (%s원)".formatted(new DecimalFormat().format(money));
        return matchCountMessage + (isBonusMatched ? bonusMatchMessage : "") + prizeMessage;
    }

    @Override
    public int compareTo(IPrizeOutput obj) {
        return Integer.compare(money, obj.money());
    }
}