package lotto.util;

import java.util.List;

public class LottoValidator {
    private static void checkNumberCount(List<Integer> numbers){
        if (numbers.size() != 6) {
            throw ExceptionStatus.IllegalLottoSizeException.makeException();
        }
    }
    private static void checkNumberDuplicate(List<Integer> numbers){
        int distinctSize = (int) numbers.stream().distinct().count();
        if(distinctSize != 6){
            throw ExceptionStatus.IllegalLottoDuplicationException.makeException();
        }
    }
    private static void checkNumberLottoScope(int number){
        if(number>45 || number<=0){
            throw ExceptionStatus.IllegalLottoScopeException.makeException();
        }
    }
    private static void checkNumbersLottoScope(List<Integer> numbers){
        numbers.forEach(LottoValidator::checkNumberLottoScope);
    }
    public static void checkBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        checkNumberLottoScope(bonusNumber);
        LottoValidator.checkNumberLottoScope(bonusNumber); // 유효 범위
        if(winningNumbers.contains(bonusNumber)){ // 당첨 번호와 중복 체크
            throw ExceptionStatus.IllegalBonusException.makeException();
        }
    }

    public static void checkLottoVaild(List<Integer> numbers){
        checkNumberCount(numbers);
        checkNumberDuplicate(numbers);
        checkNumbersLottoScope(numbers);
    }
}
