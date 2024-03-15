package lotto.model.entity.lotto.prize;

import java.util.Map;
import java.util.HashMap;

public enum PrizeEnum {
    NONE_0(0, Boolean.ANY, 0),
    NONE_1(1, Boolean.ANY, 0),
    NONE_2(2, Boolean.ANY, 0),
    FIFTH(3, Boolean.ANY, 5_000),
    FOURTH(4, Boolean.ANY, 50_000),
    THIRD(5, Boolean.FALSE, 1_500_000),
    SECOND(5, Boolean.TRUE, 30_000_000),
    FIRST(6, Boolean.ANY, 2_000_000_000);

    private final int countMatched;
    private final Boolean isBonusMatched;
    private final int prize;

    private static final Map<Map.Entry<Integer, Boolean>, PrizeEnum> lookup = new HashMap<>();

    static {
        for (PrizeEnum prize : values()) {
            lookup.put(Map.entry(prize.countMatched, prize.isBonusMatched), prize);
        }
    }

    PrizeEnum(int countMatched, Boolean isBonusMatched, int prize) {
        this.countMatched = countMatched;
        this.isBonusMatched = isBonusMatched;
        this.prize = prize;
    }

    public static PrizeEnum of(int matchCount, boolean matchBonus) {
        return lookup.getOrDefault(Map.entry(matchCount, matchBonus), NONE_0);
    }

    int getCountMatched() {
        return countMatched;
    }

    boolean getIsBonusMatched() {
        return isBonusMatched.equals(Boolean.TRUE);
    }

    int getPrize() {
        return prize;
    }

    private enum Boolean {
        TRUE,
        FALSE,
        ANY
    }
}