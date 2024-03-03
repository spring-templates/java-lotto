package lotto;

import lotto.model.LottoCompany;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoCompanyTest {

    @DisplayName("당첨 번호의 개수가 6개가 아니면 예외가 발생한다.")
    @Test
    void createLottoCompanyByOverSize() {
        Assertions.assertThatThrownBy(() ->
                        new LottoCompany(List.of(45,17,42,36,1,2,9), 8))
                .isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() ->
                        new LottoCompany(List.of(45,17,42,36,1), 8))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("당첨 번호가 유효 범위 밖에 있으면 예외가 발생한다")
    @Test
    void createLottoCompanyByWinningOverScope() {
        Assertions.assertThatThrownBy(() ->
                        new LottoCompany(List.of(45,17,42,36,1,46), 8))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 유효 범위 밖에 있으면 예외가 발생한다")
    @Test
    void createLottoCompanyByBonusOverScope() {
        Assertions.assertThatThrownBy(() ->
                        new LottoCompany(List.of(45,17,42,36,1,6), 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 보너스 번호가 중복되면 예외가 발생한다")
    @Test
    void createLottoCompanyByOverScope() {
        Assertions.assertThatThrownBy(() ->
                        new LottoCompany(List.of(45,17,42,36,1,46), 46))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
