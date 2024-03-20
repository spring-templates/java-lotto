package lotto.controller;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import lotto.model.money.MoneyInputValidator;
import lotto.view.sin.MoneyInputView;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoPurchaseTest {
    private final String lf = System.lineSeparator();


    private MoneyConsoleInput getController(Scanner scanner) {
        return MoneyConsoleInput.of(scanner);
    }

    @Disabled
    @DisplayName("음이 아닌 Integer에 대한 돈 발행")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 1000, Integer.MAX_VALUE})
    void inputMoney(int number) {
        // given
        String input = number + lf;
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        var controller = getController(new Scanner(System.in));

        // then
        Assertions.assertDoesNotThrow(controller::tryInput);
    }

    @DisplayName("음수로는 돈 발행 불가")
    @ParameterizedTest
    @ValueSource(ints = {-1, Integer.MIN_VALUE})
    void negativeMoney(int number) {
        // given
        String input = number + lf;
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        var controller = getController(scanner);

        // then
        Assertions.assertThrows(IllegalArgumentException.class, controller::tryInput);
    }

    @DisplayName("Integer 범위를 넘어서는 돈 발행 불가")
    @ParameterizedTest
    @ValueSource(longs = {Long.MIN_VALUE, Long.MAX_VALUE})
    void negativeMoney(long number) {
        // given
        String input = number + lf;
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        var controller = getController(scanner);

        // then
        Assertions.assertThrows(IllegalArgumentException.class, controller::tryInput);
    }

}
