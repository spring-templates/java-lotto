package lotto.model;

import lotto.model.dto.Money;
import lotto.model.enums.LottoDefinition;
import lotto.model.enums.LottoExceptionStatus;

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
            throw new IllegalArgumentException(LottoExceptionStatus.IllegalPurchaseRemainderException.getMessage());
        }
    }

    public static void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        validateNumberLottoScope(bonusNumber);
        Lotto.validateNumberLottoScope(bonusNumber); // 유효 범위
        if(winningNumbers.contains(bonusNumber)){ // 당첨 번호와 중복 체크
            throw new IllegalArgumentException(LottoExceptionStatus.IllegalBonusDuplicateException.getMessage());
        }
    }

    public static void validateLottoNumbers(List<Integer> numbers){
        validateNumberCount(numbers);
        validateNumberDuplicate(numbers);
        validateNumbersLottoScope(numbers);
    }
    private static void validateNumberCount(List<Integer> numbers){
        if (numbers.size() != LottoDefinition.SelectionSize.getNumber()) {
            throw new IllegalArgumentException(LottoExceptionStatus.IllegalLottoSizeException.getMessage());
        }
    }
    private static void validateNumberDuplicate(List<Integer> numbers){
        int distinctSize = (int) numbers.stream().distinct().count();
        if(distinctSize != LottoDefinition.SelectionSize.getNumber()){
            throw new IllegalArgumentException(LottoExceptionStatus.IllegalLottoDuplicateException.getMessage());
        }
    }
    private static void validateNumberLottoScope(int number){
        if(number>LottoDefinition.MaximumNumber.getNumber() || number<LottoDefinition.MinimunNumber.getNumber()){
            throw new IllegalArgumentException(LottoExceptionStatus.IllegalLottoScopeException.getMessage());
        }
    }
    private static void validateNumbersLottoScope(List<Integer> numbers){
        numbers.forEach(Lotto::validateNumberLottoScope);
    }
}
