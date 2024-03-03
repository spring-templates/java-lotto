package lotto.model;
import lotto.util.LottoValidator;

import java.util.List;
import java.util.stream.Collectors;

public record Lotto(List<Integer> numbers) {

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream() // 정렬해서 저장
                .sorted()
                .collect(Collectors.toList());
    }

    private void validate(List<Integer> numbers) {
        // 숫자 개수
        LottoValidator.checkNumberCount(numbers);
        // 중복 숫자
        LottoValidator.checkNumberDuplicate(numbers);
        // 로또 숫자 범위
        LottoValidator.checkNumbersLottoScope(numbers);
    }
    // TODO: 추가 기능 구현
    @Override
    public String toString(){
        return numbers.toString();
    }
}
