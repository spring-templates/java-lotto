package controller;

import lotto.controller.LottoGenerator;
import lotto.model.Customer;
import lotto.util.ExceptionStatus;
import lotto.view.InputManager;
import lotto.view.OutputManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class LottoGeneratorTest {

    @Test
    public void testCreateCustomerWithRemainderPurchaseAmount(){
        InputManager inputManager = mock(InputManager.class);
        OutputManager outputManager = mock(OutputManager.class);

        // 사용자가 1000으로 나눠떨어지지 않는 값을 입력한 경우와 사용자가 정상적인 값을 입력한 경우
        when(inputManager.enterPurchaseAmount()).thenReturn(100).thenReturn(1000);

        LottoGenerator lottoGenerator = new LottoGenerator();
        Customer customer = lottoGenerator.createCustomer(inputManager, outputManager);
        assertNotNull(customer);

        verify(inputManager, times(2))
                .enterPurchaseAmount();
        // displayErrorMessage가 1번 호출되었는지 확인
        verify(outputManager, times(1))
                .displayErrorMessage(ExceptionStatus.IllegalPurchaseRemainderException.getMessage());
        // 다른 검증 로직 추가 가능
    }

    @Test
    public void testCreateCustomerWithNegativePurchaseAmount(){
        InputManager inputManager = mock(InputManager.class);
        OutputManager outputManager = mock(OutputManager.class);

        // 사용자가 1000으로 나눠떨어지지 않는 값을 입력한 경우와 사용자가 정상적인 값을 입력한 경우
        when(inputManager.enterPurchaseAmount()).thenReturn(-100).thenReturn(1000);

        LottoGenerator lottoGenerator = new LottoGenerator();
        Customer customer = lottoGenerator.createCustomer(inputManager, outputManager);
        assertNotNull(customer);

        verify(inputManager, times(2))
                .enterPurchaseAmount(); // 메서드가 1번 호출되었는지 확인
        // displayErrorMessage가 1번 호출되었는지 확인
        verify(outputManager, times(1))
                .displayErrorMessage(ExceptionStatus.IllegalPurchaseNegativeException.getMessage());
        // 다른 검증 로직 추가 가능
    }

}
