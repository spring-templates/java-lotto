package lotto.model.entity.money;

import base.model.ModelValidator;

class MoneyModelValidator extends ModelValidator<IMoneyInputDto, MoneyOutputDto> {

    @Override
    public void validate(IMoneyInputDto input) throws IllegalArgumentException {
        if (input.money() == null) {
            throw new IllegalArgumentException("[ERROR] input.money() == null");
        }
        if (input.money() < 0) {
            throw new IllegalArgumentException("[ERROR] input.money() < 0");
        }
    }

    @Override
    public void validate(MoneyOutputDto lottoOutputDto) throws IllegalArgumentException {

    }
}
