package lotto.controller;

import base.model.Validator;
import base.view.ConsoleInput;
import base.view.View;
import lotto.model.money.IMoneyInput;
import lotto.model.money.LottoCostInputValidator;
import lotto.model.money.MoneyInputDto;
import lotto.view.sin.MoneyInputView;

import java.util.Scanner;

/**
 * MoneyConsoleInput을 Singleton에 맞게 생성자는 private으로 수정
 */
public class MoneyConsoleInput extends ConsoleInput<IMoneyInput> {
    private MoneyConsoleInput(View<IMoneyInput> view, Validator<IMoneyInput> validator, Scanner scanner) {
        super(view, validator, scanner);
    }

    public static MoneyConsoleInput of(Scanner scanner) {
        return new MoneyConsoleInput(
                new MoneyInputView(),
                new LottoCostInputValidator(),
                scanner
        );
    }

    @Override
    protected IMoneyInput parseDto(String input) throws IllegalArgumentException {
        try {
            int money = Integer.parseInt(input);
            return MoneyInputDto.of(money);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Integer.parseInt(in) throws NumberFormatException");
        }
    }
}
