package lotto.util;

public class ExceptionHandler {
    private static final String ERROR_MESSAGE = GlobalExceptionMessageEnum.ERROR_MESSAGE.getValue();

    public static String handle(IllegalArgumentException e) {
        return String.format("%s %s", ERROR_MESSAGE, e.getMessage());
    }
}
