package lotto.view;

import java.io.*;
import java.util.List;
import lotto.model.entity.*;
import lotto.model.vendor.prize.LottoPrizeVendor;
import org.junit.jupiter.api.*;

class OutputViewTest {

    private List<Lotto> purchasedLottos;
    private Lotto winningLotto;
    private LottoBonusNumber winningBonusNumber;
    ByteArrayOutputStream outputStreamCaptor;


    public OutputViewTest() {
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
        purchasedLottos = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 45)),
                new Lotto(List.of(1, 2, 3, 4, 44, 45)),
                new Lotto(List.of(1, 2, 3, 43, 44, 45))
        );

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
        // given
        purchasedLottos = List.of(
                new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45))
        );
        winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        winningBonusNumber = new LottoBonusNumber(winningLotto, 7);

        // when
        LottoPrizeVendor lottoVendor = new LottoPrizeVendor(winningLotto, winningBonusNumber);
        OutputView.printStatistics(lottoVendor, purchasedLottos);

        // then
        String expectedOutput = """
                당첨 통계
                ---
                3개 일치 (5,000원) - 1개
                4개 일치 (50,000원) - 0개
                5개 일치 (1,500,000원) - 0개
                5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
                6개 일치 (2,000,000,000원) - 0개
                총 수익률은 62.5%입니다.
                """.trim();
        String actualOutput = outputStreamCaptor.toString().replace("\r\n", "\n").trim();
        Assertions.assertEquals(expectedOutput, actualOutput);
    }
}