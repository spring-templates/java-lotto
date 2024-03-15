package lotto.model.entity.money;

import base.model.Entity;

final class MoneyEntity extends Entity<IMoneyInputDto, MoneyOutputDto> implements IMoneyOutputDto {
    private final Money money;

    public MoneyEntity(IMoneyInputDto input) throws IllegalArgumentException {
        super(input, new MoneyModelValidator());
        this.money = new Money(input.money());
        modelValidator.validate(toDto());
    }

    @Override
    public MoneyOutputDto toDto() {
        return new MoneyOutputDto(money());
    }

    @Override
    public Integer money() {
        return money.money();
    }

    private record Money(Integer money) implements IMoneyOutputDto {
    }
}
