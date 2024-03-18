package lotto.controller;

import base.controller.Converter;
import base.view.View;
import java.util.ArrayList;
import java.util.Random;
import java.util.TreeSet;
import lotto.model.lotto.ILottoOutput;
import lotto.model.lotto.ILottoPurchaseOutput;
import lotto.model.lotto.LottoOutputDto;
import lotto.model.lotto.LottoPurchaseOutputDto;
import lotto.model.money.IMoneyInput;

public class MoneyToPurchaseLotto extends Converter<IMoneyInput, ILottoPurchaseOutput> {

    public MoneyToPurchaseLotto(View<ILottoPurchaseOutput> view) {
        super(view);
    }

    @Override
    public ILottoPurchaseOutput convert(IMoneyInput iMoneyInput) {
        var tmp = new ArrayList<ILottoOutput>();
        int size = iMoneyInput.money() / 1000;
        while (size-- > 0) {
            tmp.add(generateRandomLotto());
        }
        return new LottoPurchaseOutputDto(tmp);
    }

    private LottoOutputDto generateRandomLotto() {
        var random = new Random();
        var numbers = new TreeSet<Integer>();
        while (numbers.size() < 6) {
            numbers.add(random.nextInt(45) + 1);
        }
        return new LottoOutputDto(numbers);
    }
}
