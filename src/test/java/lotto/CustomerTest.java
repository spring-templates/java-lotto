package lotto;

import lotto.model.Customer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CustomerTest {


    @DisplayName("구매 금액이 0 미만이면 예외를 발생한다.")
    @Test
    void createCustomerByNegativeAmount() {
        Assertions.assertThatThrownBy(() -> Customer.createCustomer(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액이 1000으로 나눠 떨어지지 않으면 예외를 발생한다.")
    @Test
    void createCustomerBy1000Remainder() {
        Assertions.assertThatThrownBy(() -> Customer.createCustomer(1024))
                .isInstanceOf(IllegalArgumentException.class);
    }

//    @DisplayName("Customer 객체를 생성하고 추후에 로또 리스트를 입력할 수 있다.")
//    @Test
//    void createCustomerAndAddLottoList() {
//        Customer customer = Customer.createCustomer(12000);
//        Assertions.assertThatThrownBy(() -> customer.withLottos(List.of(12,3,34,5,7,32,1)))
//                .isInstanceOf(IllegalArgumentException.class);
//    }
}
