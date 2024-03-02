package lotto.data;
import lotto.util.ExceptionStatus;
import java.util.List;
import java.util.stream.Collectors;

public record Lotto(List<Integer> numbers) {

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream() // 정렬해서 저장
                .sorted()
                .collect(Collectors.toList());
    }

    private void validate(List<Integer> numbers) {
        // 숫가 개수
        if (numbers.size() != 6) {
            throw ExceptionStatus.IllegalLottoSizeException.makeException();
        }
        // 중복 숫자
        int distinctSize = (int) numbers.stream().distinct().count();
        if(distinctSize != 6){
            throw ExceptionStatus.IllegalLottoDuplicationException.makeException();
        }
        // 로또 숫자 범위
        boolean result = numbers.stream()
                .anyMatch(number -> number>45 || number<=0);
        if(result){
            throw ExceptionStatus.IllegalLottoScopeException.makeException();
        }
    }
    // TODO: 추가 기능 구현
}
