package lotto.model.entity;

public record Prize(Integer matchCount, Boolean bonusMatch) {
    public Prize {
        validate(matchCount, bonusMatch);
    }

    private void validate(Integer matchCount, Boolean bonusMatch) {
        if (matchCount == null) {
            throw new IllegalArgumentException("matchCount must not be null");
        }
        if (bonusMatch == null) {
            throw new IllegalArgumentException("bonusMatch must not be null");
        }
        if (matchCount < 0) {
            throw new IllegalArgumentException("matchCount must be greater than or equal to 0");
        }
        if (matchCount > 6) {
            throw new IllegalArgumentException("matchCount must be less than or equal to 6");
        }
    }

    public Integer prizeMoney() {
        return this.hashCode();
    }

    @Override
    public int hashCode() {
        if (matchCount == 6) {
            return 2000000000;
        }
        if (matchCount == 5 && bonusMatch) {
            return 30000000;
        }
        if (matchCount == 5) {
            return 1500000;
        }
        if (matchCount == 4) {
            return 50000;
        }
        if (matchCount == 3) {
            return 5000;
        }
        return 0;
    }

    @Override
    public String toString() {
        String res = String.format("%d개 일치", matchCount);
        if (bonusMatch) {
            res += ", 보너스 볼 일치";
        }
        res += String.format(" (%,d원)", prizeMoney());
        return res;
    }
}
