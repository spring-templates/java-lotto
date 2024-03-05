package lotto.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import lotto.model.entity.Lotto;
import lotto.model.entity.Money;

class LottoGenerateService {
    private final Money lottoPrice;

    LottoGenerateService(Money lottoPrice) {
        this.lottoPrice = lottoPrice;
    }

    List<Lotto> purchaseMultipleLotto(Money money) throws IllegalArgumentException {
        validateMoney(money);
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = money.amount(); i > 0; i -= lottoPrice.amount()) {
            lottoList.add(generateSingleLotto());
        }
        return lottoList;
    }

    private void validateMoney(Money money) throws IllegalArgumentException {
        if (money == null) {
            throw new IllegalArgumentException("Invalid money. Money cannot be null.");
        }
        if (money.amount() <= 0) {
            throw new IllegalArgumentException("Invalid money amount. The amount must be positive.");
        }
        if (money.amount() % lottoPrice.amount() != 0) {
            throw new IllegalArgumentException(
                    String.format("Invalid money amount. The amount must be a multiple of %d.", lottoPrice.amount()));
        }
    }

    private Lotto generateSingleLotto() {
        return new Lotto(generateUniqueNumbers(6));
    }

    private SortedSet<Integer> generateUniqueNumbers(int n) throws IllegalArgumentException {
        if (n <= 0) {
            throw new IllegalArgumentException("Invalid number of elements. Number of elements must be positive.");
        }
        SortedSet<Integer> uniqueNumbers = new TreeSet<>();
        while (uniqueNumbers.size() < n) {
            int randomNumber = (int) (Math.random() * 45) + 1;
            uniqueNumbers.add(randomNumber);
        }
        return uniqueNumbers;
    }

}
