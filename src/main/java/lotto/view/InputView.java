package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import lotto.model.entity.Lotto;
import lotto.model.entity.Money;
import lotto.model.util.ExceptionHandler;

public class InputView {

    public static Money inputLottoExpense() throws IllegalArgumentException {
        return new Money(inputSingleInteger("구입금액을 입력해 주세요."));
    }

    public static Lotto inputWinningLotto() {
        while (true) {
            try {
                List<Integer> input = inputCommaSeperatedIntegers("당첨 번호를 입력해 주세요.");
                Lotto.validate(input);
                return new Lotto(input);
            } catch (IllegalArgumentException e) {
                ExceptionHandler.handle(e);
            }
        }
    }


    public static Integer inputBonusNumber(Lotto winningLotto) {
        while (true) {
            try {
                Integer input = inputSingleInteger("보너스 번호를 입력해 주세요.");
                Lotto.validate(input);
                if (winningLotto.numbers().contains(input)) {
                    throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
                }
                return input;
            } catch (IllegalArgumentException e) {
                ExceptionHandler.handle(e);
            }
        }
    }

    private static List<Integer> inputCommaSeperatedIntegers(String message) throws IllegalArgumentException {
        try {
            System.out.println(message);
            String input = new Scanner(System.in).nextLine();
            List<Integer> lottoNumbers = new ArrayList<>();
            for (String number : input.split(",")) {
                lottoNumbers.add(Integer.parseInt(number));
            }
            return lottoNumbers;
        } catch (NoSuchElementException | NumberFormatException ignored) {
            throw new IllegalArgumentException("The input is not a comma separated list of integers.");
        }
    }

    private static Integer inputSingleInteger(String message) throws IllegalArgumentException {
        try {
            System.out.println(message);
            return Integer.parseInt(new Scanner(System.in).nextLine());
        } catch (NoSuchElementException | NumberFormatException ignored) {
            throw new IllegalArgumentException("The input is not a single integer.");
        }
    }
}
