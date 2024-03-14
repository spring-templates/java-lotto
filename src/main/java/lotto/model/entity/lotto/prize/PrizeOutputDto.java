package lotto.model.entity.lotto.prize;

import lotto.model.entity.money.IMoneyOutputDto;

public record PrizeOutputDto(
        Integer matchedNumberCount,
        Boolean isBonusMatched,
        IMoneyOutputDto prize

) implements IPrizeOutputDto {
    @Override
    public String toString() {
        String matchCountMessage = String.format("%d개 일치", matchedNumberCount);
        String bonusMatchMessage = ", 보너스 볼 일치";
        String prizeMessage = String.format(" (%d원)", prize.money());
        return matchCountMessage + (isBonusMatched ? bonusMatchMessage : "") + prizeMessage;
    }
}