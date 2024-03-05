package lotto.model;

import lombok.Builder;
import lotto.util.ExceptionStatus;
import lotto.util.LottoValidator;

import java.util.List;
import java.util.stream.Collectors;

public record LottoCompany(List<Integer> winningNumbers,int bonusNumber) {

    //Builder
    public static final class Builder {
        List<Integer> winningNumbers;
        int bonusNumber;
        public Builder winningNumbers(List<Integer> winningNumbers){
            validateWinningNumbers(winningNumbers);
            this.winningNumbers = winningNumbers.stream() // 정렬해서 저장
                    .sorted()
                    .collect(Collectors.toList());
            return this;
        }
        public Builder bonusNumber(int bonusNumber){
            validateBonusNumber(this.winningNumbers, bonusNumber);
            this.bonusNumber = bonusNumber;
            return this;
        }
        public LottoCompany build(){
            return new LottoCompany(winningNumbers, bonusNumber);
        }
    }

    private static void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        LottoValidator.checkNumberLottoScope(bonusNumber); // 유효 범위
        if(winningNumbers.contains(bonusNumber)){ // 당첨 번호와 중복 체크
            throw ExceptionStatus.IllegalBonusException.makeException();
        }
    }

    private static void validateWinningNumbers(List<Integer> winningNumbers) {
        // 숫자 개수
        LottoValidator.checkNumberCount(winningNumbers);
        // 중복 숫자
        LottoValidator.checkNumberDuplicate(winningNumbers);
        // 로또 숫자 범위
        LottoValidator.checkNumbersLottoScope(winningNumbers);
    }

}
