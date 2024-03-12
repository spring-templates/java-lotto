package service;

import lotto.model.Lotto;
import lotto.model.dto.Money;
import lotto.model.dto.PrizeNumbers;
import lotto.model.service.LottoResultCalculator;
import lotto.model.enums.Winnings;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultCalculatorTest {

    @DisplayName("당첨 결과의 정상적인 제공 테스트")
    @Test
    public void testProvideWinningDetails() {
        // Given
        LottoResultCalculator lottoResultCalculator = new LottoResultCalculator();
        List<Lotto> customerLottos = List.of(
                new Lotto(List.of(1,2,3,4,5,6)), // 1등
                new Lotto(List.of(1,2,3,4,5,45)), // 2등
                new Lotto(List.of(1,2,3,4,5,36)), // 3등
                new Lotto(List.of(1,2,3,4,25,16)), // 4등
                new Lotto(List.of(1,2,3,14,25,16)), // 5등
                new Lotto(List.of(1,2,7,14,25,16))  // Fail
        );
        PrizeNumbers prizeNumbers = new PrizeNumbers(
                List.of(1,2,3,4,5,6),
                45
        );

        // When
        Map<Winnings, Integer> mp = lottoResultCalculator.provideWinningDetails(customerLottos, prizeNumbers);

        // Then
        mp.forEach((key, value) -> assertThat(value).isEqualTo(1));
    }

    @DisplayName("당첨 결과에 따라 수익금 계산 테스트")
    @Test
    public void testCalculateReturn(){
        // Given
        LottoResultCalculator lottoResultCalculator = new LottoResultCalculator();
        HashMap<Winnings, Integer> lottoResult = new LinkedHashMap<>();
        lottoResult.put(Winnings.First,1);
        lottoResult.put(Winnings.Second,1);
        lottoResult.put(Winnings.Third,2);
        lottoResult.put(Winnings.Fourth,3);
        lottoResult.put(Winnings.Fifth,3);

        Money money = new Money(10000);
        //When
        String result = lottoResultCalculator.calculateReturn(lottoResult, money);
        System.out.println(result);
        //Then
        assertThat(result).isEqualTo("20331650.0");
    }
}
