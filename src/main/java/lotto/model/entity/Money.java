package lotto.model.entity;

public record Money(Integer amount) {
    public Money {
        validateAmount(amount);
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
