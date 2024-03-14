package lotto.model.entity.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberValidationTest {

    private final LottoGenerator generator = new LottoGenerator();
    private final Random random = new Random();
    private final List<Integer> mayDuplicatedInput = new ArrayList<>();
    private final SortedSet<Integer> mustNotDuplicatedInput = new TreeSet<>();

    @BeforeEach
    void setUp() {
        while (mayDuplicatedInput.size() < 6) {
            mayDuplicatedInput.add(random.nextInt(1, 45));
        }
        while (mustNotDuplicatedInput.size() < 6) {
            mustNotDuplicatedInput.add(random.nextInt(1, 45));
        }
    }

    @DisplayName("duplicated input")
    @Test
    void noDuplication() {
        // given
        mayDuplicatedInput.remove(5);
        int duplicatedNumber = mayDuplicatedInput.get(0);
        mayDuplicatedInput.add(duplicatedNumber);
        // when
        Executable lambda = () -> generator.generate(new LottoInputDto(mayDuplicatedInput));
        // then
        Assertions.assertThrows(IllegalArgumentException.class, lambda);
    }

    @DisplayName("edge case")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void outOfRange(int number) {
        // given
        mustNotDuplicatedInput.remove(5);
        mustNotDuplicatedInput.add(number);
        List<Integer> input = mustNotDuplicatedInput.stream().toList();
        // when
        Executable lambda = () -> generator.generate(new LottoInputDto(input));
        // then
        Assertions.assertThrows(IllegalArgumentException.class, lambda);
    }

}
