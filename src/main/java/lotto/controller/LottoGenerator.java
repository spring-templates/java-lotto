package lotto.controller;

import lombok.AllArgsConstructor;
import lotto.model.Customer;
import lotto.model.Lotto;
import lotto.view.InputManager;
import lotto.view.OutputManager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@AllArgsConstructor
public class LottoGenerator {

    private final InputManager inputManager;
    private final OutputManager outputManager;

    // 구입 금액 입려과 고객 생성
    public Customer createCustomer(){
        while(true){
            try{
                int amount = inputManager.enterPurchaseAmount();
                return Customer.createCustomer(amount);
            }
            catch(IllegalArgumentException e){
                outputManager.displayErrorMessage(e.getMessage());
            }
        }
    }

    public int countLottosBasedOnAmount(Customer customer){
        return customer.purchaseAmount()/1000;
    }

    public List<Lotto> createLottos(int lottoQuantity) {
        return IntStream.range(0, lottoQuantity)
                .mapToObj(i -> createLotto())
                .collect(Collectors.toList());
    }

    private Lotto createLotto(){
        Set<Integer> numbers = new HashSet<>();
        while(numbers.size()<=5) {
            int temp = (int) (Math.random() * 45 + 1); // 1~45 사이 값 무작위로 추출
            numbers.add(temp);
        }
        return new Lotto(numbers.stream().toList());
    }
}
