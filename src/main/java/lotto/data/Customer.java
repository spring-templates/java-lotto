package lotto.data;

import lotto.util.CustomException;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int purchaseAmount;
    private List<Lotto> lottos = new ArrayList<>();
    private static Customer instance;

    public static Customer getInstance(int purchaseAmount){
        if(instance == null){
            instance = new Customer(purchaseAmount);
        }
        return instance;
    }

    private Customer(int purchaseAmount){
        this.purchaseAmount = vaildPurchaseAmount(purchaseAmount);
    }

    private int vaildPurchaseAmount(int purchaseAmount){
        if(purchaseAmount%1000 >0){ // 1000으로 나눠 떨어지지 않는 경우
            throw new CustomException(ExceptionStatus.IllegalPurchaseRemainderException);
        }
        if(purchaseAmount <0){
            throw new CustomException(ExceptionStatus.IllegalPurchaseNegativeException);
        }
        return purchaseAmount;
    }
}
