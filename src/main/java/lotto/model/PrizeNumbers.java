package lotto.model;

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
}
