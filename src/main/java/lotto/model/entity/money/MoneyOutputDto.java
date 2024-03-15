package lotto.model.entity.money;

public record MoneyOutputDto(
        Integer money
) implements IMoneyOutputDto, Comparable<IMoneyOutputDto> {
    public static MoneyOutputDto of(IMoneyInputDto input) {
        return new MoneyGenerator().generate(input);
    }

    @Override
    public String toString() {
        return money.toString();
    }

    @Override
    public int compareTo(IMoneyOutputDto obj) {
        return Integer.compare(money, obj.money());
    }
}
