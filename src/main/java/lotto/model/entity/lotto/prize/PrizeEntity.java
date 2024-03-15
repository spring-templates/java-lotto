package lotto.model.entity.lotto.prize;

import base.model.Entity;
import lotto.model.entity.money.MoneyGenerator;
import lotto.model.entity.money.MoneyInputDto;
import lotto.model.entity.money.MoneyOutputDto;

final class PrizeEntity extends Entity<IPrizeInputDto, PrizeOutputDto> implements
        IPrizeOutputDto {
    private final Prize info;

    public PrizeEntity(IPrizeInputDto input) throws IllegalArgumentException {
        super(input, new PrizeModelValidator());
        this.info = prizeFactory(input);
        modelValidator.validate(toDto());
    }

    private Prize prizeFactory(IPrizeInputDto input) {
        Integer countNumberMatched = input.winningLotto().countNumberMatched(input.lotto());
        Boolean isBonusMatched = input.bonusNumber().isBonusMatched(input.lotto());
        PrizeEnum prizeEnum = PrizeEnum.of(countNumberMatched, isBonusMatched);
        MoneyOutputDto money = new MoneyGenerator().generate(new MoneyInputDto(prizeEnum.getPrize()));
        return new Prize(countNumberMatched, isBonusMatched, money);
    }

    @Override
    public PrizeOutputDto toDto() {
        return new PrizeOutputDto(matchedNumberCount(), isBonusMatched(), prize());
    }

    @Override
    public Integer matchedNumberCount() {
        return info.matchedNumberCount();
    }

    @Override
    public Boolean isBonusMatched() {
        return info.isBonusMatched();
    }

    @Override
    public MoneyOutputDto prize() {
        return info.prize();
    }

    private record Prize(
            Integer matchedNumberCount,
            Boolean isBonusMatched,
            MoneyOutputDto prize
    ) implements IPrizeOutputDto {
    }
}
