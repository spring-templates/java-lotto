package lotto.model.entity.lotto;


import base.Validator;
import java.util.SortedSet;

class LottoValidator extends Validator<ILotto> {

    @Override
    protected void validate(ILotto iLotto) throws IllegalArgumentException {
        SortedSet<Integer> numbers = iLotto.numbers();
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] numbers == null || numbers.isEmpty()");
        }
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] numbers.size() != 6");
        }
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] number < 1 || number > 45");
            }
        }
    }

    void validate(ILottoInputDto input) throws IllegalArgumentException {
        if (input == null) {
            throw new IllegalArgumentException("[ERROR] input == null");
        }
        if (input.numbers() == null) {
            throw new IllegalArgumentException("[ERROR] input.numbers() == null");
        }
        if (input.numbers().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] input.numbers().isEmpty()");
        }
        if (input.numbers().size() != 6) {
            throw new IllegalArgumentException("[ERROR] input.numbers().size() != 6");
        }
    }
}
