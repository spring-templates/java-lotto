package lotto.model.entity.money;

import base.Generator;

public class MoneyGenerator extends Generator<IMoneyInputDto, MoneyOutputDto> {

    @Override
    public MoneyOutputDto generate(IMoneyInputDto input) throws IllegalArgumentException {
        return getEntity(input).toDto();
    }

    @Override
    protected MoneyEntity getEntity(IMoneyInputDto input) {
        return new MoneyEntity(input);
    }
}
