package lotto.model.entity.money;

import base.model.Entity;
import base.model.Generator;

public class MoneyGenerator extends Generator<IMoneyInputDto, MoneyOutputDto> {
    @Override
    protected final Entity<IMoneyInputDto, MoneyOutputDto> getEntity(IMoneyInputDto input) {
        return new MoneyEntity(input);
    }
}
