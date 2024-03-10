package lotto.model.vendor;

import java.util.List;
import lotto.model.entity.Money;
import lotto.model.entity.Priced;

public interface IVendor<P extends Priced> {
    List<P> purchase(Money money) throws IllegalArgumentException;
}
