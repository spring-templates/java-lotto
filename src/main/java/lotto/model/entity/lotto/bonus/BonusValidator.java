package lotto.model.entity.lotto.bonus;


import base.Validator;

class BonusValidator extends Validator<IBonusInputDto, BonusOutputDto> {

    @Override
    public void validate(IBonusInputDto input) throws IllegalArgumentException {
        Integer bonusNumber = input.bonusNumber();
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("bonusNumber < 1 || bonusNumber > 45");
        }
        if (input.numbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("input.numbers().contains(bonusNumber)");
        }
    }

    @Override
    public void validate(BonusOutputDto output) throws IllegalArgumentException {

    }
}