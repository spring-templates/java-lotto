package lotto;

import java.util.List;

import lotto.data.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @DisplayName("로또 번호가 정렬되어 저장된다.")
    @Test
    void createLottoBySorted() {
        Assertions.assertThat(new Lotto(List.of(45,3,4,5,1,2)).numbers())
                .isEqualTo(List.of(1,2,3,4,5,45));
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        Assertions.assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        Assertions.assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능
    @DisplayName("로또 번호가 유효 범위 밖에 있으면 예외가 발생한다.")
    @Test
    void createLottoByOverScope() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        Assertions.assertThatThrownBy(() -> new Lotto(List.of(0, 2, 3, 4, 5, 45)))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() -> new Lotto(List.of(46, 2, 3, 4, 5, 45)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}