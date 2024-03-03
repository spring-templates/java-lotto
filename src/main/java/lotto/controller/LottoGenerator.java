package lotto.controller;

import lotto.model.Customer;
import lotto.view.InputManager;
import lotto.view.OutputManager;

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

}
