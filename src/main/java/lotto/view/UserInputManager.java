package lotto.view;

import java.util.*;

public class UserInputManager implements InputManager {
    private final Scanner scanner;// 선언

    // 생성자에서 Scanner 주입
    public UserInputManager(Scanner scanner) {
        this.scanner = scanner;
    }
    @Override
    public int enterPurchaseAmount() {
        try{
            StringTokenizer st = new StringTokenizer(scanner.nextLine());
            return Integer.parseInt(st.nextToken());
        } catch (NumberFormatException | InputMismatchException e){
            throw new IllegalArgumentException("[ERROR] 당첨금은 정수일 때 입력할 수 있어요.");
        }
    }

    @Override
    public List<Integer> enterWinningNumbers() {
        List<Integer> list = new ArrayList<>();
        try{
            StringTokenizer st = new StringTokenizer(scanner.nextLine());
            while(st.hasMoreTokens()) { //hasMoreTokens() : 토큰이 남아있다면 true, 없으면 false 리턴
                list.add(Integer.parseInt(st.nextToken()));
            }
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 당첨금은 정수일 때 입력할 수 있어요.");
        }
        return list;
    }

    @Override
    public int enterBonusNumber() {
        try{
            return Integer.parseInt(scanner.nextLine());
        }catch (NumberFormatException | InputMismatchException e){
            throw new IllegalArgumentException("[ERROR] 당첨금은 정수일 때 입력할 수 있어요.");
        }
    }
}
