package lotto;

import lotto.model.entity.Money;
import lotto.model.service.LottoVendor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoVendorTest {

    private final int lottoPrice = LottoVendor.lottoPrice.amount();

    @DisplayName("로또 구매 금액이 로또 가격의 배수이면 로또를 구매할 수 있다")
    @Test
    void purchaseLotto() {
        Assertions.assertThat(LottoVendor.purchase(new Money(lottoPrice * 2))).hasSize(2);
    }

    @DisplayName("로또 구매 금액이 0원 이하이면 예외가 발생한다")
    @Test
    void purchaseLottoByNotEnoughMoney() {
        Assertions.assertThatThrownBy(() -> LottoVendor.purchase(new Money(0)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 구매 금액이 로또 가격의 배수가 아니면 예외가 발생한다")
    @Test
    void purchaseLottoByNotMultipleOfLottoPrice() {
        Assertions.assertThatThrownBy(() -> LottoVendor.purchase(new Money(lottoPrice + 1)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
