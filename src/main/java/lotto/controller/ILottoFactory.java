package lotto.controller;

import java.util.List;
import lotto.model.entity.*;
import lotto.model.vendor.IVendor;
import lotto.model.vendor.prize.LottoPrizeVendor;

public interface ILottoFactory {

    List<Lotto> purchaseLotto(IVendor<Lotto> vendor);

    Lotto inputWinningLotto();

    LottoBonusNumber inputBonusNumber(Lotto lotto);

    LottoPrizeVendor inputPrizeVendor();
}
