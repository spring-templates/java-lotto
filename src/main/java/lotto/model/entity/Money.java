package lotto.model.entity;

public record Money(String currency, Integer amount) {
    public Money {
        validateCurrency(currency);
        validateAmount(amount);
    }

    public Money(Integer integer) {
        this("원", integer);
    }

    public static void validateCurrency(String currency) throws IllegalArgumentException {
        if (currency == null) {
            throw new IllegalArgumentException("Currency must not be null");
        }
        if (!"원".equals(currency)) {
            throw new IllegalArgumentException("Currency supports only 원 for now");
        }
    }

    public static void validateAmount(Integer amount) throws IllegalArgumentException {
        if (amount == null) {
            throw new IllegalArgumentException("Amount must not be null");
        }
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must not be negative");
        }
    }
}
