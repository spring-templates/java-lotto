package lotto.controller;

import base.model.Validator;
import base.view.ConsoleInput;
import base.view.View;
import java.util.List;
import lotto.model.lotto.winning.IWinningLottoInput;
import lotto.model.lotto.winning.WinningLottoInputDto;

public class WinningLottoConsoleInput extends ConsoleInput<IWinningLottoInput> {
    public WinningLottoConsoleInput(
            View<IWinningLottoInput> view,
            Validator<IWinningLottoInput> validator
    ) {
        super(view, validator);
    }

    @Override
    protected IWinningLottoInput parseDto(String input) throws IllegalArgumentException {
        try {
            List<Integer> numbers = parseInput(input);
            return new WinningLottoInputDto(numbers);
        } catch (Exception e) {
            throw new IllegalArgumentException("The input is not a comma separated list of integers.");
        }
    }

    private List<Integer> parseInput(String input) throws NumberFormatException {
        var split = List.of(input.split(","));
        return split.stream().map(Integer::parseInt).toList();
    }
}
