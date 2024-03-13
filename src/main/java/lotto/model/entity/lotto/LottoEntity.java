package lotto.model.entity.lotto;

import java.util.SortedSet;
import java.util.TreeSet;
import base.Entity;

final class LottoEntity extends Entity<ILottoInputDto, ILottoOutputDto> implements ILotto {
    private final ILotto lotto;

    public LottoEntity(ILottoInputDto input) throws IllegalArgumentException {
        super(input);
        SortedSet<Integer> numbers = new TreeSet<>(input.numbers());
        this.lotto = new Lotto(numbers);
    }

    @Override
    protected void validate(ILottoInputDto iLottoInputDto) throws IllegalArgumentException {
        if (iLottoInputDto == null) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 입력되지 않았습니다.");
        }
        if (iLottoInputDto.numbers().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 입력되지 않았습니다.");
        }
        if (iLottoInputDto.numbers().size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
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

