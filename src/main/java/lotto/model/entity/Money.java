package lotto.model.entity;

public record Money(int amount) implements Comparable<Money> {
    public Money {
        validate(amount);
    }

    public static void validate(int amount) throws IllegalArgumentException {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must not be negative");
        }
    }

    @Override
    public int compareTo(Money price) {
        return Integer.compare(this.amount, price.amount);
    }

    @Override
    public String toString() {
        return String.valueOf(amount);
    }
}
