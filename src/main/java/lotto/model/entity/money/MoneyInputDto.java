package lotto.model.entity.money;


public record MoneyInputDto(
        Integer money
) implements IMoneyInputDto {
    @Override
    public String toString() {
        return money.toString();
    }
}
