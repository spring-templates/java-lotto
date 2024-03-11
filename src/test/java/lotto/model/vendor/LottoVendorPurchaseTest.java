package lotto.model.vendor;

import lotto.model.entity.Money;
import lotto.util.LottoEnum;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

public class LottoVendorPurchaseTest {

    private final int lottoPrice = LottoEnum.PRICE.getValue();
    private final LottoVendor vendor = new LottoVendor();


    @DisplayName("로또 구매 금액이 로또 가격의 배수이면 로또를 구매할 수 있다")
    @Test
    void purchaseLotto() {
        Money money = new Money(lottoPrice * 2);
        Assertions.assertThat(vendor.purchase(money)).hasSize(2);
    }

    @DisplayName("로또 구매 금액이 0원 이하이면 예외가 발생한다")
    @Test
    void purchaseLottoByNotEnoughMoney() {
        Money money = new Money(0);
        Assertions.assertThatThrownBy(() -> vendor.purchase(money)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매 금액이 로또 가격의 배수가 아니면 예외가 발생한다")
    @Test
    void purchaseLottoByNotMultipleOfLottoPrice() {
        Money money = new Money(lottoPrice + 1);
        Assertions.assertThatThrownBy(() -> vendor.purchase(money)).isInstanceOf(IllegalArgumentException.class);
    }
}
