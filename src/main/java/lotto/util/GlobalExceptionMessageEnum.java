package lotto.util;

import lombok.Getter;

@Getter
public enum GlobalExceptionMessageEnum {
    ERROR_MESSAGE("[ERROR]");
    private final String value;

    GlobalExceptionMessageEnum(String value) {
        this.value = value;
    }

}
