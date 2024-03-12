package lotto.model.dto;

import lombok.Getter;

@Getter
public class Money {
    private int money;
    public Money(int money){
        validateMoney(money);
        this.money = money;
    }
    private void validateMoney(int money){
        if(money < 0 )
            // Lotto와는 관련 없는 에러 메시지기 때문에 따로 enum 처리하지 않음
            throw new IllegalArgumentException("[ERROR] 구입 금액은 0 이상일 때 입력할 수 있어요.");
    }
}
