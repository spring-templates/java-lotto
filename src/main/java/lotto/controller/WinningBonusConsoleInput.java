package lotto.controller;

import base.model.Validator;
import base.view.ConsoleInput;
import base.view.View;
import java.util.NoSuchElementException;
import lotto.model.bonus.BonusInputDto;
import lotto.model.bonus.IBonusInput;
import lotto.model.lotto.winning.IWinningLottoOutput;

public class WinningBonusConsoleInput extends ConsoleInput<IBonusInput> {

    private final IWinningLottoOutput winningLotto;

    public WinningBonusConsoleInput(
            View<IBonusInput> view,
            Validator<IBonusInput> validator,
            IWinningLottoOutput winningLotto
    ) throws IllegalArgumentException {
        super(view, validator);
        this.winningLotto = winningLotto;
    }

    @Override
    protected IBonusInput parseDto(String input) throws IllegalArgumentException {
        try {
            return new BonusInputDto(winningLotto.numbers(), Integer.parseInt(input));
        } catch (NoSuchElementException | NumberFormatException e) {
            throw new IllegalArgumentException("The input is not a integer.");
        }
    }
}
