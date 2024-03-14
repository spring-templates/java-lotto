package lotto.model.entity.money;

import base.model.Entity;
import base.model.Generator;

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
