package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInputManager implements InputManager {
    private final Scanner sc = new Scanner(System.in);
    @Override
    public int enterPurchaseAmount() {
        return sc.nextInt();
    }

    @Override
    public List<Integer> enterWinningNumbers() {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<6; i++){
            list.add(sc.nextInt());
        }
        return list;
    }

    @Override
    public int enterBonusNumber() {
        return sc.nextInt();
    }
}
