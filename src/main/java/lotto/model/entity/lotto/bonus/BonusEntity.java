package lotto.model.entity.lotto.bonus;

import base.Entity;
import java.util.SortedSet;

final class BonusEntity extends Entity<IBonusInputDto, BonusOutputDto> implements IBonusOutputDto {
    private final Bonus lotto;

    public BonusEntity(IBonusInputDto input) throws IllegalArgumentException {
        super(input, new BonusValidator());
        this.lotto = new Bonus(input.numbers(), input.bonusNumber());
        validator.validate(toDto());
    }

    @Override
    public BonusOutputDto toDto() {
        return new BonusOutputDto(bonusNumber());
    }

    @Override
    public Integer bonusNumber() {
        return lotto.bonusNumber();
    }

    private record Bonus(SortedSet<Integer> numbers, Integer bonusNumber) implements IBonusInputDto {
    }
}
