package lotto.model.entity.lotto.prize;

enum PrizeEnum {
    NONE(0, Boolean.ANY, 0),
    FIFTH(3, Boolean.ANY, 5_000),
    FOURTH(4, Boolean.ANY, 50_000),
    THIRD(5, Boolean.FALSE, 1_500_000),
    SECOND(5, Boolean.TRUE, 30_000_000),
    FIRST(6, Boolean.ANY, 2_000_000_000);

    private final int countMatched;
    private final Boolean isBonusMatched;
    private final int prize;

    PrizeEnum(int countMatched, Boolean isBonusMatched, int prize) {
        this.countMatched = countMatched;
        this.isBonusMatched = isBonusMatched;
        this.prize = prize;
    }

    public static PrizeEnum of(int matchCount, boolean matchBonus) {
        for (PrizeEnum prize : values()) {
            boolean isCountMatched = prize.countMatched == matchCount;
            boolean isBonusUseless = Boolean.ANY.equals(prize.isBonusMatched);
            boolean isBonusMatched = prize.isBonusMatched.equals(matchBonus ? Boolean.TRUE : Boolean.FALSE);

            if (isCountMatched && (isBonusUseless || isBonusMatched)) {
                return prize;
            }
        }
        return NONE;
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
