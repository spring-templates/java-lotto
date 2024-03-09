package lotto.util;

public enum LottoDefinition {
    MaximumNumber(45),
    MinimunNumber(1),
    PriceOfLotto(1000);

    private final int number;

    LottoDefinition(int number){
        this.number = number;
    }
}
