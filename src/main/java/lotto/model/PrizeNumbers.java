package lotto.model;

import lotto.util.ExceptionStatus;
import lotto.util.LottoDefinition;
import lotto.util.LottoValidator;

import java.util.List;
import java.util.stream.Collectors;

// 생성되고 더 이상 수정되지 않음
public record PrizeNumbers(List<Integer> winningNumbers, int bonusNumber){

    public PrizeNumbers(List<Integer> winningNumbers, int bonusNumber){
        this.winningNumbers = winningNumbers.stream() // 정렬해서 저장
                    .sorted()
                    .collect(Collectors.toList());
        this.bonusNumber = bonusNumber;
    }
    public static void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        validateNumberLottoScope(bonusNumber);
        PrizeNumbers.validateNumberLottoScope(bonusNumber); // 유효 범위
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
        numbers.forEach(PrizeNumbers::validateNumberLottoScope);
    }
}
