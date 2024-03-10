package lotto.controller;

import java.util.List;
import lotto.model.entity.Lotto;
import lotto.model.entity.Lotto.LottoBonusNumber;
import lotto.model.vendor.IVendor;
import lotto.model.vendor.prize.LottoPrizeVendor;

public interface ILottoFactory {

    List<Lotto> purchaseLotto(IVendor<Lotto> vendor);

    Lotto inputWinningLotto();

    LottoBonusNumber inputBonusNumber(Lotto lotto);

    LottoPrizeVendor inputPrizeVendor();
}
