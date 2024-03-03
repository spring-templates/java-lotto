package lotto.controller;

import lotto.model.Customer;
import lotto.model.Lotto;
import lotto.view.InputManager;
import lotto.view.OutputManager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

    // 구입 금액 입려과 고객 생성
    public Customer createCustomer(InputManager inputManager, OutputManager outputManager){
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
        try{
            List<Integer> integerList = new ArrayList<>();
            while(integerList.size()<=5){
                int temp = (int)(Math.random()*45+1); // 1~45 사이 값 무작위로 추출
                if(!integerList.contains(temp))
                    integerList.add(temp);
            }
            return new Lotto(integerList);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
