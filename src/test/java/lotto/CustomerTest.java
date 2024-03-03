package lotto;

import lotto.model.Customer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CustomerTest {
    @DisplayName("싱글톤은 재정의를 해도 이미 정의한 객체를 호출한다.")
    @Test
    void createCustomerByTwice() {
        Customer.getInstance(1234000);
        Assertions.assertThat(Customer.getInstance(43422000).getPurchaseAmount())
                .isEqualTo(Customer.getInstance().getPurchaseAmount());
    }

    @DisplayName("구매 금액이 0 미만이면 예외를 발생한다.")
    @Test
    void createCustomerByNegativeAmount() {
        Assertions.assertThatThrownBy(() -> Customer.getInstance(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액이 1000으로 나눠 떨어지지 않으면 예외를 발생한다.")
    @Test
    void createCustomerBy1000Remainder() {
        Assertions.assertThatThrownBy(() -> Customer.getInstance(1024))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
