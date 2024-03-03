package lotto.model.entity;

import java.util.ArrayList;
import java.util.List;

public record CustomerSession(List<Lotto> purchasedLotto) {
    public CustomerSession() {
        this(new ArrayList<>());
    }

    public void addLotto(Lotto lotto) {
        purchasedLotto.add(lotto);
    }

    public void addLotto(List<Lotto> lottoList) {
        purchasedLotto.addAll(lottoList);
    }
}
