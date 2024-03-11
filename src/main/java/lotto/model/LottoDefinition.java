package lotto.model;

public enum LottoDefinition {
    MaximumNumber(45),
    MinimunNumber(1),
    PriceOfLotto(1000),
    SelectionSize(6);

    private final int number;

    LottoDefinition(int number){
        this.number = number;
    }
    public int getNumber(){
        return number;
    }
}
