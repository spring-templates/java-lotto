package lotto.model.entity.money;

import base.Entity;

final class MoneyEntity extends Entity<IMoneyInputDto, MoneyOutputDto> implements
        IMoneyOutputDto {
    private final Money money;

    public MoneyEntity(IMoneyInputDto input) throws IllegalArgumentException {
        super(input, new MoneyValidator());
        this.money = new Money(input.money());
        validator.validate(toDto());
    }

    @Override
    protected MoneyOutputDto toDto() {
        return new MoneyOutputDto(money());
    }

    @Override
    public Integer money() {
        return money.money();
    }

    private record Money(Integer money) implements IMoneyOutputDto {
    }
}
