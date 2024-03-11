package lotto.model.entity;

import java.util.*;
import lotto.util.LottoEnum;

public record Lotto(SortedSet<Integer> numbers) implements Priced {

    public Lotto(SortedSet<Integer> numbers) {
        this.numbers = numbers;
        validate();
    }

    public Lotto(List<Integer> numbers) {
        this(new TreeSet<>(numbers));
        int NUMBER_LENGTH = LottoEnum.NUMBER_LENGTH.getValue();
        if (numbers.size() != NUMBER_LENGTH) {
            throw new IllegalArgumentException("로또 번호는 " + NUMBER_LENGTH + "개여야 합니다.");
        }
    }

    private void validate() {
        int NUMBER_LENGTH = LottoEnum.NUMBER_LENGTH.getValue();
        int MIN_NUMBER = LottoEnum.MIN_NUMBER.getValue();
        int MAX_NUMBER = LottoEnum.MAX_NUMBER.getValue();
        if (numbers.size() != NUMBER_LENGTH) {
            throw new IllegalArgumentException("로또 번호는 중복 없는 숫자 " + NUMBER_LENGTH + "개여야 합니다.");
        }
        if (numbers.first() < MIN_NUMBER || numbers.last() > MAX_NUMBER) {
            throw new IllegalArgumentException("각각의 로또 번호는 " + MIN_NUMBER + "이상 " + MAX_NUMBER + "이하의 숫자여야 합니다.");
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    @Override
    public Money getPrice() {
        int value = LottoEnum.PRICE.getValue();
        return new Money(value);
    }

    public int countMatch(Lotto lotto) {
        long count = numbers.stream().filter(lotto.numbers::contains).count();
        return (int) count;
    }

    public boolean contains(Integer number) {
        return numbers.contains(number);
    }

    public boolean contains(LottoBonusNumber bonusNumber) {
        return contains(bonusNumber.number);
    }

}
