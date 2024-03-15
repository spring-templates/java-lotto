package lotto;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ApplicationTest {
    private final String lf = System.lineSeparator();
    private ByteArrayOutputStream actual;

    @BeforeEach
    void setUp() {
        actual = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actual));
    }

    @DisplayName("Application 실행 테스트")
    @Test
    void integrationTest() {
        // given
        String[] args = {"8000", "1,2,3,4,5,6", "7"};
        String expected = makeStringByArgs(args);
        // when
        Application.main(args);
        // then
        Assertions.assertEquals(expected.trim(), actual.toString().trim());
    }

    private String makeStringByArgs(String[] args) {
        String inputMoney = "구입금액을 입력해 주세요." + lf + args[0] + lf;
        String outputPurchasedLotto = """
                8개를 구매했습니다.
                [8, 21, 23, 41, 42, 43]
                [3, 5, 11, 16, 32, 38]
                [7, 11, 16, 35, 36, 44]
                [1, 8, 11, 31, 41, 42]
                [13, 14, 16, 38, 42, 45]
                [7, 11, 30, 40, 42, 43]
                [2, 13, 22, 32, 38, 45]
                [1, 3, 5, 14, 22, 45]
                """.replace("\n", lf);
        String inputWinningLotto = "당첨 번호를 입력해 주세요." + lf + args[1] + lf;
        String inputWinningBonus = "보너스 번호를 입력해 주세요." + lf + args[2] + lf;
        String outputPrizeStatistics = """
                당첨 통계
                ---
                3개 일치 (5,000원) - 1개
                4개 일치 (50,000원) - 0개
                5개 일치 (1,500,000원) - 0개
                5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
                6개 일치 (2,000,000,000원) - 0개
                총 수익률은 62.5%입니다.
                """.replace("\n", lf);
        return concatLines(inputMoney, outputPurchasedLotto, inputWinningLotto, inputWinningBonus,
                outputPrizeStatistics);
    }

    private String concatLines(String... lines) {
        return String.join(lf, lines) + lf;
    }
}
