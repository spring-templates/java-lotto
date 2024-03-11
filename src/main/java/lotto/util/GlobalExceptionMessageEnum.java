package lotto.util;

public enum GlobalExceptionMessageEnum {
    ERROR_MESSAGE("[ERROR]");
    private final String value;

    GlobalExceptionMessageEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
