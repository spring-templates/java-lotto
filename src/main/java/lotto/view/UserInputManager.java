package lotto.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class UserInputManager implements InputManager {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 선언
    @Override
    public int enterPurchaseAmount() {
        try{
            return Integer.parseInt(br.readLine());
        } catch (NumberFormatException | IOException e){
            throw new IllegalArgumentException("[ERROR] 당첨금은 정수일 때 입력할 수 있어요.");
        }
    }

    @Override
    public List<Integer> enterWinningNumbers() {
        List<Integer> list = new ArrayList<>();
        try{
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) { //hasMoreTokens() : 토큰이 남아있다면 true, 없으면 false 리턴
                list.add(Integer.parseInt(st.nextToken()));
            }
        }catch (IOException e){
            throw new IllegalArgumentException("[ERROR] 당첨금은 정수일 때 입력할 수 있어요.");
        }
        return list;
    }

    @Override
    public int enterBonusNumber() {
        try{
            return Integer.parseInt(br.readLine());
        }catch (IOException e){
            throw new IllegalArgumentException("[ERROR] 당첨금은 정수일 때 입력할 수 있어요.");
        }
    }
}
