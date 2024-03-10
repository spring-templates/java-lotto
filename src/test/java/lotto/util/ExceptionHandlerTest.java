package lotto.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExceptionHandlerTest {
    @DisplayName("예외 메세지 출력 테스트")
    @Test
    void handledErrorMessageShouldStartWithPrefix() {
        String errorPrefix = GlobalExceptionMessageEnum.ERROR_MESSAGE.getValue();
        String message = ExceptionHandler.handle(new IllegalArgumentException());
        Assertions.assertThat(message).startsWith(errorPrefix);
    }
}
