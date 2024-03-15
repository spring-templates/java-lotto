package lotto.model.entity.lotto.prize;


import base.model.ModelValidator;

class PrizeModelValidator extends ModelValidator<IPrizeInputDto, PrizeOutputDto> {

    @Override
    public void validate(IPrizeInputDto input) throws IllegalArgumentException {
        input.bonusNumber();
        input.winningLotto();
        input.lotto();
    }

    @Override
    public void validate(PrizeOutputDto lottoOutputDto) throws IllegalArgumentException {

    }
}
