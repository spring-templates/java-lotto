package lotto.data;

import lombok.Getter;
import lombok.Setter;
import lotto.util.ExceptionStatus;
import java.util.List;


public class Customer {
    @Getter
    private final int purchaseAmount;
    @Setter
    @Getter
    private List<Lotto> lottos;
    @Getter
    private static Customer instance;

    public static Customer getInstance(int purchaseAmount){
        if(instance == null){
            instance = new Customer(purchaseAmount);
        }
        return instance;
    }

    private Customer(int purchaseAmount){
        validPurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
    }

    private void validPurchaseAmount(int purchaseAmount){
        if(purchaseAmount%1000 > 0){ // 1000으로 나눠 떨어지지 않는 경우
            throw ExceptionStatus.IllegalPurchaseRemainderException.makeException();
        }
        if(purchaseAmount <0){ // 0 미만인 경우
            throw ExceptionStatus.IllegalPurchaseNegativeException.makeException();
        }
    }
}
