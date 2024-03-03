package lotto.model.entity;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public record Lotto(SortedSet<Integer> numbers) {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int REQUIRED_LENGTH = 6;

    public Lotto {
        validate(numbers);
    }

    public Lotto(List<Integer> numbers) {
        this(new TreeSet<>(numbers));
    }

    public static void validate(List<Integer> numbers) {
        validate(new TreeSet<>(numbers));
    }

    public static void validate(SortedSet<Integer> numbers) throws IllegalArgumentException {
        if (numbers == null) {
            throw new IllegalArgumentException("Numbers must not be null");
        }
        if (numbers.size() != REQUIRED_LENGTH) {
            throw new IllegalArgumentException(
                    "Numbers must contain " + REQUIRED_LENGTH + " elements without duplicates");
        }
        numbers.forEach(Lotto::validate);
    }

    public static void validate(Integer number) throws IllegalArgumentException {
        if (number == null) {
            throw new IllegalArgumentException("Number must not be null");
        }
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("Number must be between " + MIN_NUMBER + " and " + MAX_NUMBER);
        }
    }

    public static Lotto of(List<Integer> numbers) {
        SortedSet<Integer> sortedNumbers = new TreeSet<>(numbers);
        validate(sortedNumbers);
        return new Lotto(sortedNumbers);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int number : numbers) {
            sb.append(number).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        return sb.toString();
    }
}