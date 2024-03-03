package lotto.model;

import lotto.util.ExceptionStatus;
import lotto.util.LottoValidator;

import java.util.List;
import java.util.stream.Collectors;

public record LottoCompany(List<Integer> winningNumbers,int bonusNumber) {
    public LottoCompany(List<Integer> winningNumbers, int bonusNumber) {
        validateWinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers.stream() // 정렬해서 저장
                .sorted()
                .collect(Collectors.toList());
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        LottoValidator.checkNumberLottoScope(bonusNumber); // 유효 범위
        if(winningNumbers.contains(bonusNumber)){ // 당첨 번호와 중복 체크
            throw ExceptionStatus.IllegalBonusException.makeException();
        }
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        // 중복 숫자
        LottoValidator.checkNumberDuplicate(winningNumbers);
        // 로또 숫자 범위
        LottoValidator.checkNumbersLottoScope(winningNumbers);
    }

}
