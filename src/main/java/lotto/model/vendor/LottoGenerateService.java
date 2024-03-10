package lotto.model.vendor;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import lotto.model.entity.Lotto;
import lotto.model.entity.Money;
import lotto.util.LottoEnum;

class LottoGenerateService {

    private final int price = LottoEnum.PRICE.getValue();

    List<Lotto> purchaseMultipleLotto(Money money) throws IllegalArgumentException {
        validateMoney(money);
        List<Lotto> lottoList = new ArrayList<>();
        int numberOfLottoShouldBePurchased = money.amount() / price;
        while (lottoList.size() < numberOfLottoShouldBePurchased) {
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
        if (money.amount() % price != 0) {
            throw new IllegalArgumentException(
                    String.format("Invalid money amount. The amount must be a multiple of %d.", price));
        }
    }

    private Lotto generateSingleLotto() {
        return new Lotto(generateUniqueNumbers());
    }

    private SortedSet<Integer> generateUniqueNumbers() {
        int n = LottoEnum.NUMBER_LENGTH.getValue();
        int max = LottoEnum.MAX_NUMBER.getValue();
        int min = LottoEnum.MIN_NUMBER.getValue();

        SortedSet<Integer> uniqueNumbers = new TreeSet<>();
        while (uniqueNumbers.size() < n) {
            int randomNumber = (int) (Math.random() * max) + min;
            uniqueNumbers.add(randomNumber);
        }
        return uniqueNumbers;
    }

}
