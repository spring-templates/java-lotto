package lotto.model.entity.lotto.prize.stats;


import base.model.Validator;

class StatsValidator extends Validator<IStatsInputDto, StatsOutputDto> {

    @Override
    public void validate(IStatsInputDto input) throws IllegalArgumentException {
        if (input.purchasedLotto().isEmpty()) {
            throw new IllegalArgumentException("input.purchasedLotto().isEmpty()");
        }
    }

    @Override
    public void validate(StatsOutputDto output) throws IllegalArgumentException {
        if (output.prizeStats().isEmpty()) {
            throw new IllegalArgumentException("output.prizeStats().isEmpty()");
        }
    }
}
