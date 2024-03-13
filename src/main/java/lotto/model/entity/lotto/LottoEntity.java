package lotto.model.entity.lotto;

import base.Entity;
import java.util.SortedSet;
import java.util.TreeSet;

final class LottoEntity extends Entity<ILottoInputDto, ILottoOutputDto> implements ILotto {
    private final ILotto lotto;

    public LottoEntity(ILottoInputDto input) throws IllegalArgumentException {
        super(input);
        SortedSet<Integer> numbers = new TreeSet<>(input.numbers());
        this.lotto = new Lotto(numbers);
    }

    @Override
    protected void validate(ILottoInputDto input) throws IllegalArgumentException {
        new LottoValidator().validate(input);
    }

    @Override
    public ILottoOutputDto toDto() {
        return new LottoOutputDto(lotto.numbers());
    }

    @Override
    public SortedSet<Integer> numbers() {
        return lotto.numbers();
    }

    private record Lotto(SortedSet<Integer> numbers) implements ILotto {
    }
}
