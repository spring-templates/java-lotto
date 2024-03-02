package lotto.util;

import lotto.data.ExceptionStatus;

public class CustomException extends RuntimeException{
    private ExceptionStatus status;

    public CustomException(ExceptionStatus status) {
        super(status.getMessage());
        this.printStackTrace();
        this.status = status;
    }

    public ExceptionStatus getStatus() {
        return this.status;
    }
}
