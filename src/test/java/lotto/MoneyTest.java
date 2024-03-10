package lotto;

import lotto.model.Money;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MoneyTest {

    @Test
    void getMoneyByNegativeAmount() {
        Assertions.assertThatThrownBy(() -> new Money(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
