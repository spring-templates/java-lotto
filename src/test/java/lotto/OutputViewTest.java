package lotto;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import lotto.model.entity.Lotto;
import lotto.model.service.LottoVendor;
import lotto.view.OutputView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    ByteArrayOutputStream outputStreamCaptor;
    private final Lotto winningLotto;
    private final int winningBonusNumber;
    private final List<Lotto> purchasedLottos;

    public OutputViewTest() {
        winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        winningBonusNumber = 7;
        purchasedLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 45)),
                new Lotto(List.of(1, 2, 3, 4, 44, 45)),
                new Lotto(List.of(1, 2, 3, 43, 44, 45))
        );
    }

    @BeforeEach
    void setUp() {
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }

    @DisplayName("구매한 로또를 콘솔로 출력한다.")
    @Test
    void printLotto() {
        Assertions.assertDoesNotThrow(() -> OutputView.printLotto(purchasedLottos));

        String expectedOutput = """
                5개를 구매했습니다.
                [1, 2, 3, 4, 5, 6]
                [1, 2, 3, 4, 5, 7]
                [1, 2, 3, 4, 5, 45]
                [1, 2, 3, 4, 44, 45]
                [1, 2, 3, 43, 44, 45]
                """.trim();

        String actualOutput = outputStreamCaptor.toString().replace("\r\n", "\n").trim();

        Assertions.assertEquals(expectedOutput, actualOutput);
    }

    @DisplayName("콘솔로 출력되는 결과가 동일한지 확인한다.")
    @Test
    void calculatePrize() {
        Assertions.assertDoesNotThrow(() -> OutputView.printStatistics(LottoVendor.lottoPrice.amount(),
                LottoVendor.calculatePrize(purchasedLottos, winningLotto, winningBonusNumber)));

        String expectedOutput = """
                당첨 통계
                ---
                3개 일치 (5,000원) - 1개
                4개 일치 (50,000원) - 1개
                5개 일치 (1,500,000원) - 1개
                5개 일치, 보너스 볼 일치 (30,000,000원) - 1개
                6개 일치 (2,000,000,000원) - 1개
                총 수익률은 40631100.0%입니다.
                """.trim();

        String actualOutput = outputStreamCaptor.toString().replace("\r\n", "\n").trim();

        Assertions.assertEquals(expectedOutput, actualOutput);
    }
}