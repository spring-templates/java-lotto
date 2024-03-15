package lotto.view;

import base.view.OutputView;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;
import lotto.model.entity.lotto.LottoOutputDto;
import lotto.model.entity.lotto.LottoPurchaseOutputDto;
import lotto.model.entity.lotto.prize.PrizeOutputDto;
import lotto.model.entity.lotto.prize.PrizeStatsOutputDto;
import lotto.model.entity.money.MoneyOutputDto;
import lotto.view.sout.LottoPurchaseOutputView;
import lotto.view.sout.PrizeStatisticsOutputView;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        LottoPurchaseOutputDto input = new LottoPurchaseOutputDto(
                List.of(
                        createLottoOutputDto(List.of(8, 21, 23, 41, 42, 43)),
                        createLottoOutputDto(List.of(3, 5, 11, 16, 32, 38)),
                        createLottoOutputDto(List.of(7, 11, 16, 35, 36, 44)),
                        createLottoOutputDto(List.of(1, 8, 11, 31, 41, 42)),
                        createLottoOutputDto(List.of(13, 14, 16, 38, 42, 45)),
                        createLottoOutputDto(List.of(7, 11, 30, 40, 42, 43)),
                        createLottoOutputDto(List.of(2, 13, 22, 32, 38, 45)),
                        createLottoOutputDto(List.of(1, 3, 5, 14, 22, 45))
                ));
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

    private LottoOutputDto createLottoOutputDto(List<Integer> numbers) {
        return new LottoOutputDto(new TreeSet<>(numbers));
    }

    @DisplayName("당첨 통계 출력 테스트")
    @Test
    void prizeStatisticsOutput() {
        // given
        SortedMap<PrizeOutputDto, Integer> input = new TreeMap<>();
        PrizeOutputDto key = createPrizeKey(0, false, 0);
        input.put(key, input.getOrDefault(key, 0) + 1);
        key = createPrizeKey(1, false, 0);
        input.put(key, input.getOrDefault(key, 0) + 2);
        key = createPrizeKey(2, false, 0);
        input.put(key, input.getOrDefault(key, 0) + 4);
        input.put(createPrizeKey(3, false, 5_000), 1);
        input.put(createPrizeKey(4, false, 50_000), 0);
        input.put(createPrizeKey(5, false, 1_500_000), 0);
        input.put(createPrizeKey(5, true, 30_000_000), 0);
        input.put(createPrizeKey(6, false, 2_000_000_000), 0);
        System.out.println(input);
        String expected = """
                3개 일치 (5,000원) - 1개
                4개 일치 (50,000원) - 0개
                5개 일치 (1,500,000원) - 0개
                5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
                6개 일치 (2,000,000,000원) - 0개
                총 수익률은 62.5%입니다.
                """;

        OutputView<PrizeStatsOutputDto> view = new PrizeStatisticsOutputView();
        System.setOut(new PrintStream(actual));
        // when
        view.render(new PrizeStatsOutputDto(input));
        // then
        Assertions.assertEquals(expected.replace("\n", lf), actual.toString());
    }

    private PrizeOutputDto createPrizeKey(int count, boolean matchBonus, int prize) {
        return new PrizeOutputDto(count, matchBonus, new MoneyOutputDto(prize));
    }
}
