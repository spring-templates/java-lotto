package lotto.model;

import lombok.Getter;
import lombok.Setter;
import lotto.util.ExceptionStatus;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Customer {
    private final int purchaseAmount;
    private List<Lotto> lottos;

    private Customer(int purchaseAmount, List<Lotto> lottos) {
        validPurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
        this.lottos = new ArrayList<>();
    }

    private void validPurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % 1000 > 0) {
            throw ExceptionStatus.IllegalPurchaseRemainderException.makeException();
        }
        if (purchaseAmount < 0) {
            throw ExceptionStatus.IllegalPurchaseNegativeException.makeException();
        }
    }
    // 로또 리스트는 빈 상태로 초기 Customer 객체를 생성하기 위해 팩토리 매서드 사용
    public static Customer createCustomer(int purchaseAmount) {
        return new Customer(purchaseAmount, List.of());
    }

    // 추후에 로또 리스트가 포함된 Customer 객체 만들기 위한 팩토리 메서드
    public void withLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }
}

