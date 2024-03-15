package lotto.view;

import base.view.OutputView;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;
import lotto.model.entity.lotto.*;
import lotto.model.entity.lotto.prize.PrizeEnum;
import lotto.model.entity.lotto.prize.PrizeOutputDto;
import lotto.model.entity.lotto.prize.stats.StatsOutputDto;
import lotto.view.sout.*;
import org.junit.jupiter.api.*;

public class RenderTest {

    private final String lf = System.lineSeparator();
    private ByteArrayOutputStream actual;

    @BeforeEach
    void setUp() {
        actual = new ByteArrayOutputStream();
    }

    @DisplayName("로또 구매 출력 헤더 출력 테스트")
    @Test
    void lottoPurchaseOutput() {
        // given
        List<List<Integer>> numbers = List.of(
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );

        LottoPurchaseOutputDto input = new LottoPurchaseOutputDto(
                numbers.stream().map(LottoInputDto::of).map(LottoOutputDto::of).toList()
        );

        StringBuilder sb = new StringBuilder();
        sb.append(input.purchased().size()).append("개를 구매했습니다.").append(lf);
        input.purchased().forEach(lotto -> sb.append(lotto.numbers()).append(lf));
        String expected = sb.toString();

        OutputView<LottoPurchaseOutputDto> view = new LottoPurchaseOutputView();
        System.setOut(new PrintStream(actual));
        // when
        view.render(input);
        // then
        Assertions.assertEquals(expected, actual.toString());
    }

    @DisplayName("당첨 통계 출력 테스트")
    @Test
    void prizeStatisticsOutput() {
        // given
        SortedMap<PrizeOutputDto, Integer> input = new TreeMap<>();
        for (var key : PrizeEnum.values()) {
            input.put(PrizeOutputDto.of(key), 0);
        }
        input.put(PrizeOutputDto.of(PrizeEnum.NONE_0), 7);
        input.put(PrizeOutputDto.of(PrizeEnum.FIFTH), 1);
        String expected = """
                3개 일치 (5,000원) - 1개
                4개 일치 (50,000원) - 0개
                5개 일치 (1,500,000원) - 0개
                5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
                6개 일치 (2,000,000,000원) - 0개
                총 수익률은 62.5%입니다.
                """.replace("\n", lf);

        OutputView<StatsOutputDto> view = new PrizeStatisticsOutputView();
        System.setOut(new PrintStream(actual));
        // when
        view.render(new StatsOutputDto(input));
        // then
        Assertions.assertEquals(expected, actual.toString());
    }
}
