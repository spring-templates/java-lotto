package lotto.model.entity.lotto.prize;

import java.text.DecimalFormat;
import lotto.model.entity.money.MoneyOutputDto;

public record PrizeOutputDto(
        Integer matchedNumberCount,
        Boolean isBonusMatched,
        MoneyOutputDto prize

) implements IPrizeOutputDto, Comparable<IPrizeOutputDto> {
    public static PrizeOutputDto of(PrizeEnum prizeEnum) {
        return new PrizeOutputDto(
                prizeEnum.getCountMatched(),
                prizeEnum.getIsBonusMatched(),
                new MoneyOutputDto(prizeEnum.getPrize())
        );
    }

    public static PrizeOutputDto of(PrizeInputDto input) {
        return new PrizeGenerator().generate(input);
    }

    @Override
    public String toString() {
        String matchCountMessage = "%d개 일치".formatted(matchedNumberCount);
        String bonusMatchMessage = ", 보너스 볼 일치";
        String prizeMessage = " (%s원)".formatted(new DecimalFormat().format(prize.money()));
        return matchCountMessage + (isBonusMatched ? bonusMatchMessage : "") + prizeMessage;
    }

    @Override
    public int compareTo(IPrizeOutputDto obj) {
        return prize.compareTo(obj.prize());
    }
}