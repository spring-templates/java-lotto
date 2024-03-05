package service;

import lotto.model.Lotto;
import lotto.model.service.LottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class LottoGeneratorTest {

//    @Test
//    public void testCreateCustomerWithNegativePurchaseAmount(){
//        InputManager inputManager = mock(InputManager.class);
//        OutputManager outputManager = mock(OutputManager.class);
//
//        // 사용자가 1000으로 나눠떨어지지 않는 값을 입력한 경우와 사용자가 정상적인 값을 입력한 경우
//        when(inputManager.enterPurchaseAmount()).thenReturn(-100).thenReturn(1000);
//
//        LottoGenerator lottoGenerator = new LottoGenerator(inputManager, outputManager);
//        Customer customer = lottoGenerator.createCustomer();
//        assertNotNull(customer);
//
//        verify(inputManager, times(2))
//                .enterPurchaseAmount(); // 메서드가 1번 호출되었는지 확인
//        // displayErrorMessage가 1번 호출되었는지 확인
//        verify(outputManager, times(1))
//                .displayErrorMessage(ExceptionStatus.IllegalPurchaseNegativeException.getMessage());
//        // 다른 검증 로직 추가 가능
//    }

    @DisplayName("로또가 정해진 개수만큼 생성되는지 테스트.")
    @Test
    public void testCreateLottos(){
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Lotto> lottos = lottoGenerator.createLottos(10);
        assertEquals(10, lottos.size());
    }

    @DisplayName("로또 요소가 1에서 45 사이인지 테스트.")
    @Test
    public void testLottosScoope() {
        // Given
        LottoGenerator lottoGenerator = new LottoGenerator();
        int lottoQuantity = 10;

        // When
        List<Lotto> lottos = lottoGenerator.createLottos(lottoQuantity);

        // Then
        for (Lotto lotto : lottos) {
            assertThat(lotto.numbers())
                    .allSatisfy( n -> {
                        assertThat(n).isGreaterThan(0);
                        assertThat(n).isLessThan(46);
                    });
        }
    }
}
