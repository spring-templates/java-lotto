package lotto.model;

import lotto.model.dto.Money;
import lotto.model.enums.LottoDefinition;
import java.util.List;
import java.util.stream.Collectors;

public record Lotto(List<Integer> numbers) {

    public Lotto(List<Integer> numbers) {
        Lotto.validateLottoNumbers(numbers);
        this.numbers = numbers.stream() // 정렬해서 저장
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public String toString(){
        return numbers.toString();
    }

    public static void validateMoney(Money money){
        if (money.getMoney() % LottoDefinition.PriceOfLotto.getNumber() > 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000으로 나눠 떨어질 때 입력할 수 있어요.");
        }
    }

    public static void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        validateNumberLottoScope(bonusNumber);
        Lotto.validateNumberLottoScope(bonusNumber); // 유효 범위
        if(winningNumbers.contains(bonusNumber)){ // 당첨 번호와 중복 체크
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 보호와 중복이 없을 때 입력할 수 있어요.");
        }
    }

    public static void validateLottoNumbers(List<Integer> numbers){
        validateNumberCount(numbers);
        validateNumberDuplicate(numbers);
        validateNumbersLottoScope(numbers);
    }
    private static void validateNumberCount(List<Integer> numbers){
        if (numbers.size() != LottoDefinition.SelectionSize.getNumber()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개 숫자를 입력할 수 있어요.");
        }
    }
    private static void validateNumberDuplicate(List<Integer> numbers){
        int distinctSize = (int) numbers.stream().distinct().count();
        if(distinctSize != LottoDefinition.SelectionSize.getNumber()){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복이 없을 때 입력할 수 있어요.");
        }
    }
    private static void validateNumberLottoScope(int number){
        if(number>LottoDefinition.MaximumNumber.getNumber() || number<LottoDefinition.MinimunNumber.getNumber()){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1에서 45 사이 숫자를 입력할 수 있어요.");
        }
    }
    private static void validateNumbersLottoScope(List<Integer> numbers){
        numbers.forEach(Lotto::validateNumberLottoScope);
    }
}
