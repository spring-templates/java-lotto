package lotto.view;

import static lotto.model.service.LottoVendor.calculateProfitRate;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lotto.model.entity.Lotto;
import lotto.model.entity.Prize;

public class OutputView {

    public static void printLotto(List<Lotto> lottoList) {
        System.out.println(lottoList.size() + "개를 구매했습니다.");
        lottoList.forEach(System.out::println);
    }

    public static void printStatistics(Map<Prize, Integer> prizeMap) {
        System.out.println("당첨 통계");
        System.out.println("---");
        // 상금이 적은 순서대로 출력
        prizeMap.entrySet().stream()
                .filter(entry -> entry.getKey().prizeMoney() > 0)
                .sorted(Comparator.comparingInt(Entry::hashCode))
                .forEach(entry -> System.out.printf("%s - %d개%n", entry.getKey(), entry.getValue()));
        System.out.printf("총 수익률은 %.1f%%입니다.", calculateProfitRate(prizeMap));
    }


}
