package view;

import lotto.view.InputManager;
import lotto.view.UserInputManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import org.assertj.core.api.Assertions;

public class InputTest {

    @DisplayName("정수 입력")
    @Test
    void givenIntegerInput_whenInputManager_thenPass() {

        // Given
        ByteArrayInputStream in = new ByteArrayInputStream("10000".getBytes());
        System.setIn(in);
        InputManager inputManager = new UserInputManager();

        // When
        int purchaseAmount = inputManager.enterPurchaseAmount();

        // Then
        Assertions.assertThat(purchaseAmount).isEqualTo(10000);
    }

    @DisplayName("실수 입력")
    @Test
    void givenFloatInput_whenInputManager_thenError() {

        // Given
        ByteArrayInputStream in = new ByteArrayInputStream("10000.1".getBytes());
        System.setIn(in);
        InputManager inputManager = new UserInputManager();

        // When
        // Then
        Assertions.assertThatThrownBy(inputManager::enterPurchaseAmount)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨금은 정수일 때 입력할 수 있어요.");
    }

    @DisplayName("숫자가 아닌 값 입력")
    @Test
    void givenStringInput_whenInputManager_thenError() {

        // Given
        ByteArrayInputStream in = new ByteArrayInputStream("1000a".getBytes());
        System.setIn(in);
        InputManager inputManager = new UserInputManager();

        // When
        // Then
        Assertions.assertThatThrownBy(inputManager::enterPurchaseAmount)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨금은 정수일 때 입력할 수 있어요.");
    }
}
