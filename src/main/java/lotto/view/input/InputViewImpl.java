package lotto.view.input;

import java.util.*;
import java.util.function.Supplier;
import lotto.model.entity.*;
import lotto.view.ConsoleEnum;

class InputViewImpl implements IInputView {

    private Integer inputSingleInteger() throws IllegalArgumentException {
        try {
            return Integer.parseInt(new Scanner(System.in).nextLine());
        } catch (NoSuchElementException | NumberFormatException ignored) {
            throw new IllegalArgumentException("The input is not a single integer.");
        }
    }

    private List<Integer> inputCommaSeperatedIntegers() throws IllegalArgumentException {
        List<Integer> lottoNumbers = new ArrayList<>();
        try {
            String input = new Scanner(System.in).nextLine();
            for (String number : input.split(",")) {
                lottoNumbers.add(Integer.parseInt(number));
            }
            return lottoNumbers;
        } catch (NoSuchElementException | NumberFormatException ignored) {
            throw new IllegalArgumentException("The input is not a comma separated list of integers.");
        }
    }

    @Override
    public Money inputLottoExpense() throws IllegalArgumentException {
        Integer input = new InputExecutor<Integer>().execute(
                ConsoleEnum.PURCHASE_MONEY_INPUT_HEADER.getValue(),
                this::inputSingleInteger);
        return new Money(input);
    }

    @Override
    public Lotto inputWinningLotto() throws IllegalArgumentException {
        List<Integer> input = new InputExecutor<List<Integer>>().execute(
                ConsoleEnum.WINNING_NUMBER_INPUT_HEADER.getValue(),
                this::inputCommaSeperatedIntegers);
        return new Lotto(input);
    }

    @Override
    public LottoBonusNumber inputBonusNumber(Lotto lotto) throws IllegalArgumentException {
        int input = new InputExecutor<Integer>().execute(
                ConsoleEnum.BONUS_NUMBER_INPUT_HEADER.getValue(),
                this::inputSingleInteger);
        return new LottoBonusNumber(lotto, input);
    }

    private static class InputExecutor<T> {
        public T execute(String message, Supplier<T> supplier) throws IllegalArgumentException {
            System.out.println(message);
            try {
                return supplier.get();
            } catch (Exception e) {
                throw new IllegalArgumentException(e.getMessage());
            }
        }
    }
}
