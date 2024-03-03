package lotto.model.util;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ExceptionHandler {
    private static final Logger LOGGER = Logger.getLogger(ExceptionHandler.class.getName());
    private static final String ERROR_MESSAGE = "[ERROR]";

    public static void handle(IllegalArgumentException e) {
        System.out.println(ERROR_MESSAGE + ' ' + e.getMessage());
    }

    public static void handle(RuntimeException e) {
        LOGGER.log(Level.SEVERE, ERROR_MESSAGE + ' ' + e.getMessage(), e);
    }
}