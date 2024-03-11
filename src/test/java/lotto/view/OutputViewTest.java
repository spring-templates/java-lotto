package lotto.view;

import java.io.*;
import java.util.List;
import lotto.model.entity.*;
import lotto.model.vendor.prize.LottoPrizeVendor;
import org.junit.jupiter.api.*;

class OutputViewTest {

    private final List<Lotto> purchasedLottos;
    private final Lotto winningLotto;
    private final LottoBonusNumber winningBonusNumber;
    ByteArrayOutputStream outputStreamCaptor;


    public OutputViewTest() {
        purchasedLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 45)),
                new Lotto(List.of(1, 2, 3, 4, 44, 45)),
                new Lotto(List.of(1, 2, 3, 43, 44, 45))
        );
        winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        winningBonusNumber = new LottoBonusNumber(winningLotto, 7);
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
        Assertions.assertDoesNotThrow(() -> OutputView.printLotto(
                purchasedLottos
        ));

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

        LottoPrizeVendor lottoVendor = new LottoPrizeVendor(winningLotto, winningBonusNumber);

        OutputView.printStatistics(lottoVendor, purchasedLottos);

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