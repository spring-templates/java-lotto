package lotto.model.entity.lotto;

import base.Entity;
import java.util.SortedSet;
import java.util.TreeSet;

final class LottoEntity extends Entity<ILottoInputDto, LottoOutputDto> implements ILottoOutputDto {
    private final Lotto lotto;

    public LottoEntity(ILottoInputDto input) throws IllegalArgumentException {
        super(input, new LottoValidator());
        SortedSet<Integer> numbers = new TreeSet<>(input.numbers());
        this.lotto = new Lotto(numbers);
        validator.validate(toDto());
    }

    @Override
    protected LottoOutputDto toDto() {
        return new LottoOutputDto(lotto.numbers());
    }

    @Override
    public SortedSet<Integer> numbers() {
        return lotto.numbers();
    }

    private record Lotto(SortedSet<Integer> numbers) implements ILottoOutputDto {
    }
}
