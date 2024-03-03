package lotto.view;

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
        return null;
    }

    @Override
    public int enterBonusNumber() {
        return 0;
    }
}
