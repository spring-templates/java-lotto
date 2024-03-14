package lotto.model.entity.money;

import base.Entity;
import base.Generator;

public class MoneyGenerator extends Generator<IMoneyInputDto, MoneyOutputDto> {

    @Override
    public MoneyOutputDto generate(IMoneyInputDto input) throws IllegalArgumentException {
        return getEntity(input).toDto();
    }

    @Override
    protected final Entity<IMoneyInputDto, MoneyOutputDto> getEntity(IMoneyInputDto input) {
        return new MoneyEntity(input);
    }
}
