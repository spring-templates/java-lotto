package lotto.model;
import lotto.util.ExceptionStatus;
import lotto.util.LottoValidator;

import java.util.List;
import java.util.stream.Collectors;

public record Lotto(List<Integer> numbers) {

    public Lotto(List<Integer> numbers) {
        LottoValidator.checkLottoVaild(numbers);
        this.numbers = numbers.stream() // 정렬해서 저장
                .sorted()
                .collect(Collectors.toList());
    }
    // TODO: 추가 기능 구현
    @Override
    public String toString(){
        return numbers.toString();
    }

    public static void validateMoney(Money money){
        if (money.getMoney() % 1000 > 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000으로 나눠 떨어질 때 입력할 수 있어요.");
        }
    }
}
