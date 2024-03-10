package lotto.model.literal;

import lotto.model.entity.Money;
import lotto.model.entity.Priced;

public enum LottoPrize implements Priced {
    OTHERS(LottoPrizeCondition.OTHERS, 0),
    FIFTH(LottoPrizeCondition.FIFTH, 5_000),
    FOURTH(LottoPrizeCondition.FOURTH, 50_000),
    THIRD(LottoPrizeCondition.THIRD, 1_500_000),
    SECOND(LottoPrizeCondition.SECOND, 30_000_000),
    FIRST(LottoPrizeCondition.FIRST, 2_000_000_000);

    private final LottoPrizeCondition condition;
    private final int prize;

    LottoPrize(LottoPrizeCondition condition, int prize) {
        this.condition = condition;
        this.prize = prize;
    }

    public static LottoPrize of(int matchCount, boolean matchBonus) {
        for (LottoPrize prize : values()) {
            boolean isCountMatched = prize.condition.matchCount == matchCount;
            boolean isBonusUseless = Boolean.ANY.equals(prize.condition.isBonusMatched);
            boolean isBonusMatched = prize.condition.isBonusMatched.equals(matchBonus ? Boolean.TRUE : Boolean.FALSE);

            if (isCountMatched && (isBonusUseless || isBonusMatched)) {
                return prize;
            }
        }
        return OTHERS;
    }

    public int getMatchCount() {
        return condition.matchCount;
    }

    public boolean getBonusMatched() {
        return Boolean.TRUE.equals(condition.isBonusMatched);
    }

    @Override
    public Money getPrice() {
        return new Money(prize);
    }

    private enum LottoPrizeCondition {
        FIRST(6, Boolean.ANY),
        SECOND(5, Boolean.TRUE),
        THIRD(5, Boolean.FALSE),
        FOURTH(4, Boolean.ANY),
        FIFTH(3, Boolean.ANY),
        OTHERS(0, Boolean.ANY);

        final int matchCount;
        final Boolean isBonusMatched;

        LottoPrizeCondition(int matchCount, Boolean isBonusMatched) {
            this.matchCount = matchCount;
            this.isBonusMatched = isBonusMatched;
        }
    }

    private enum Boolean {
        TRUE,
        FALSE,
        ANY
    }
}
