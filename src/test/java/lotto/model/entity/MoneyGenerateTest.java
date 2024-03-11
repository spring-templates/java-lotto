package lotto.model.entity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

class MoneyGenerateTest {
    @DisplayName("돈의 액수가 음수이면 예외가 발생한다.")
    @Test
    void createMoneyByNegative() {
        Assertions.assertThatThrownBy(() -> new Money(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("돈의 액수가 양수이면 Money 객체가 생성된다.")
    @Test
    void createMoneyByPositive() {
        Money money = new Money(1000);
        Assertions.assertThat(money).isNotNull();
    }
}