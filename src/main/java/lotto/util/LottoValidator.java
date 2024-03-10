package lotto.util;

import java.util.List;

public class LottoValidator {
    private static void validateNumberCount(List<Integer> numbers){
        if (numbers.size() != 6) {
            throw ExceptionStatus.IllegalLottoSizeException.makeException();
        }
    }
    private static void validateNumberDuplicate(List<Integer> numbers){
        int distinctSize = (int) numbers.stream().distinct().count();
        if(distinctSize != 6){
            throw ExceptionStatus.IllegalLottoDuplicationException.makeException();
        }
    }
    private static void validateNumberLottoScope(int number){
        if(number>45 || number<=0){
            throw ExceptionStatus.IllegalLottoScopeException.makeException();
        }
    }
    private static void validateNumbersLottoScope(List<Integer> numbers){
        numbers.forEach(LottoValidator::validateNumberLottoScope);
    }
    public static void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        validateNumberLottoScope(bonusNumber);
        LottoValidator.validateNumberLottoScope(bonusNumber); // 유효 범위
        if(winningNumbers.contains(bonusNumber)){ // 당첨 번호와 중복 체크
            throw ExceptionStatus.IllegalBonusException.makeException();
        }
    }

    public static void validateLottoNumbers(List<Integer> numbers){
        validateNumberCount(numbers);
        validateNumberDuplicate(numbers);
        validateNumbersLottoScope(numbers);
    }
}
