package lotto.model.vendor;

import java.util.List;
import lotto.model.entity.Lotto;
import lotto.model.entity.Money;

public class LottoVendor implements IVendor<Lotto> {
    private final LottoGenerateService generator;

    public LottoVendor() {
        this.generator = new LottoGenerateService();
    }

    public List<Lotto> purchase(Money money) throws IllegalArgumentException {
        return generator.purchaseMultipleLotto(money);
    }
}
