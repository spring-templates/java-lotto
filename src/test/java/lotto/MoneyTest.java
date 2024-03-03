package lotto;

import lotto.model.entity.Money;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {
    @DisplayName("돈이 음수이면 예외가 발생한다.")
    @Test
    void createMoneyByNegative() {
        Assertions.assertThatThrownBy(() -> new Money(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("돈의 통화가 '원'이 아니면 예외가 발생한다.")
    @Test
    void createMoneyByUnsupportedCurrency() {
        Assertions.assertThatThrownBy(() -> new Money("달러", 1000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("돈의 통화가 '원'이고, 양수이면 Money 객체가 생성된다.")
    @Test
    void createMoneyByPositive() {
        Money money = new Money(1000);
        Assertions.assertThat(money).isNotNull();
    }
}