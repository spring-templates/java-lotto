package lotto.util;

public enum LottoEnum {
    MAX_NUMBER(45),
    MIN_NUMBER(1),
    NUMBER_LENGTH(6),
    PRICE(1000);

    private final int value;

    LottoEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
