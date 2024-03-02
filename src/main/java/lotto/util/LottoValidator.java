package lotto.util;

import java.util.List;

public class LottoValidator {
    public static void checkNumberCount(List<Integer> numbers){
        if (numbers.size() != 6) {
            throw ExceptionStatus.IllegalLottoSizeException.makeException();
        }
    }
    public static void checkNumberDuplicate(List<Integer> numbers){
        int distinctSize = (int) numbers.stream().distinct().count();
        if(distinctSize != 6){
            throw ExceptionStatus.IllegalLottoDuplicationException.makeException();
        }
    }
    public static void checkNumberLottoScope(int number){
        if(number>45 || number<=0){
            throw ExceptionStatus.IllegalLottoScopeException.makeException();
        }
    }
    public static void checkNumbersLottoScope(List<Integer> numbers){
        numbers.forEach(LottoValidator::checkNumberLottoScope);
    }
}
