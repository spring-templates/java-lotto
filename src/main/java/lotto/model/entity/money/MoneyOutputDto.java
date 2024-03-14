package lotto.model.entity.money;

public record MoneyOutputDto(
        Integer money
) implements IMoneyOutputDto {
    @Override
    public String toString() {
        return money.toString();
    }
}
