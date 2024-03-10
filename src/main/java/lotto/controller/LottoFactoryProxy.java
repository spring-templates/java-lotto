package lotto.controller;

import java.util.List;
import lotto.model.entity.Lotto;
import lotto.model.entity.Lotto.LottoBonusNumber;
import lotto.model.vendor.IVendor;
import lotto.model.vendor.LottoVendor;
import lotto.model.vendor.prize.LottoPrizeVendor;
import lotto.view.OutputView;

public class LottoFactoryProxy implements ILottoFactory {

    private final ILottoFactory lottoFactory;

    public LottoFactoryProxy() {
        this.lottoFactory = new LottoFactoryImpl();
    }

    public void run() {
        IVendor<Lotto> vendor = new LottoVendor();
        List<Lotto> purchasedLotto = purchaseLotto(vendor);
        OutputView.printLotto(purchasedLotto);
        LottoPrizeVendor lottoVendor = inputPrizeVendor();
        OutputView.printStatistics(lottoVendor, purchasedLotto);
    }

    @Override
    public List<Lotto> purchaseLotto(IVendor<Lotto> vendor) {
        return lottoFactory.purchaseLotto(vendor);
    }

    @Override
    public Lotto inputWinningLotto() {
        return lottoFactory.inputWinningLotto();
    }

    @Override
    public LottoBonusNumber inputBonusNumber(Lotto lotto) {
        return lottoFactory.inputBonusNumber(lotto);
    }

    @Override
    public LottoPrizeVendor inputPrizeVendor() {
        return lottoFactory.inputPrizeVendor();
    }
}
