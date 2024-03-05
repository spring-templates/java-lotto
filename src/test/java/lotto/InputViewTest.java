package lotto;

import java.io.ByteArrayInputStream;
import java.util.List;
import lotto.model.entity.Lotto;
import lotto.view.InputView;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    @DisplayName("구입 금액 입력 시, 정수 이외의 문자가 포함되면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"1000L", " 1000", "1000 ", "1000_10", "1000.0", "1000,0", "1000/0", "1000+0", "1000-0"})
    void inputLottoExpenseByNotNumber(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Assertions.assertThrows(IllegalArgumentException.class, InputView::inputLottoExpense);
    }

    @DisplayName("구입 금액 입력 시, 입력한 정수가 INT_MAX를 초과한다면 예외가 발생한다.")
    @Test
    void inputLottoExpenseByNumberExceedingIntMax() {
        String input = String.valueOf(1L + Integer.MAX_VALUE);
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Assertions.assertThrows(IllegalArgumentException.class, () -> InputView.inputLottoExpense());
    }

    @DisplayName("구입 금액 입력 시, 입력한 정수가 0부터 INT_MAX 사이라면 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, Integer.MAX_VALUE})
    void inputLottoExpenseByNumberEqualToIntMax(Integer integer) {
        System.setIn(new ByteArrayInputStream(String.valueOf(integer).getBytes()));
        Assertions.assertDoesNotThrow(InputView::inputLottoExpense);
    }

    @DisplayName("당첨 번호 입력 시, 쉼표로 구분된 정수 배열이 중복 없이 정확히 6개가 입력되지 않는다면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7", "1,2,3,4,5,5,6", "1,2,3,4,5,1"})
    void inputWinningLottoByNotNumber(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Assertions.assertThrows(IllegalArgumentException.class, InputView::inputWinningLotto);
    }

    @DisplayName("당첨 번호 입력 시, 입력한 정수가 1과 45 사이가 아니면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,46", "1,2,3,4,5,0", "1,2,3,4,5,-1"})
    void inputWinningLottoByNumberExceedingIntMax(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Assertions.assertThrows(IllegalArgumentException.class, InputView::inputWinningLotto);
    }

    @DisplayName("보너스 번호를 입력 시, 입력한 정수가 1과 45 사이가 아니면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"46", "0", "-1"})
    void inputBonusNumberByNumberExceedingIntMax(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Assertions.assertThrows(IllegalArgumentException.class, () -> InputView.inputBonusNumber(null));
    }

    @DisplayName("보너스 번호를 입력 시, 입력한 정수가 당첨 번호와 중복된다면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void inputBonusNumberByNumberEqualToWinningLotto(Integer integer) {
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        System.setIn(new ByteArrayInputStream(String.valueOf(integer).getBytes()));
        Assertions.assertThrows(IllegalArgumentException.class, () -> InputView.inputBonusNumber(winningLotto));
    }

}