package lotto.model.entity.money;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyValidationTest {

    private final MoneyGenerator generator = new MoneyGenerator();

    @DisplayName("edge case")
    @ParameterizedTest
    @ValueSource(ints = {-1})
    void outOfRange(int number) {
        // given
        IMoneyInputDto input = new MoneyInputDto(number);
        // when
        Executable lambda = () -> generator.generate(input);
        // then
        Assertions.assertThrows(IllegalArgumentException.class, lambda, "input.money() < 0");
    }

}
