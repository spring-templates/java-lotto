package lotto.view;

import java.util.*;
import lotto.model.entity.*;
import lotto.model.vendor.prize.IPrizeVendor;

public class OutputView {

    public static void printLotto(Collection<Lotto> lottoList) {
        System.out.printf(ConsoleEnum.LOTTO_OUTPUT_HEADER_FORMAT.getValue(), lottoList.size());
        lottoList.forEach(System.out::println);
    }

    public static void printStatistics(
            IPrizeVendor<Lotto, LottoPrize> lottoVendor,
            List<Lotto> lottoList
    ) {
        System.out.println(ConsoleEnum.STATISTICS_OUTPUT_HEADER.getValue());
        SortedMap<LottoPrize, Integer> prizeMap = countPrize(lottoVendor, lottoList);
        prizeMap.forEach(OutputView::printLottoPrize);
        System.out.println(formatProfitRate(lottoVendor, prizeMap));
    }

    private static SortedMap<LottoPrize, Integer> countPrize(
            IPrizeVendor<Lotto, LottoPrize> vendor,
            List<Lotto> lottoList
    ) {
        SortedMap<LottoPrize, Integer> prizeMap = vendor.countPrize(lottoList);
        for (LottoPrize prize : LottoPrize.values()) {
            prizeMap.putIfAbsent(prize, 0);
        }
        return prizeMap;
    }

    private static void printLottoPrize(
            LottoPrize key,
            Integer value
    ) {
        if (key.getPrice().equals(LottoPrize.NONE.getPrice())) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(ConsoleEnum.PRIZE_MATCHED_NUMBER_OUTPUT_FORMAT.getValue(), key.getMatchCount()));
        if (key.getBonusMatched()) {
            sb.append(ConsoleEnum.STATISTICS_BONUS_OUTPUT_FORMAT.getValue());
        }
        sb.append(String.format(ConsoleEnum.PRIZE_WITH_CURRENCY_OUTPUT_FORMAT.getValue(), key.getPrice().amount()));
        sb.append(String.format(ConsoleEnum.PRIZE_NUMBER_OUTPUT_FORMAT.getValue(), value));
        System.out.println(sb);
    }


    private static String formatProfitRate(
            IPrizeVendor<Lotto, LottoPrize> vendor,
            Map<LottoPrize, Integer> prizeMap
    ) {
        return String.format(
                ConsoleEnum.PROFIT_RATE_OUTPUT_FORMAT.getValue(),
                vendor.calculateProfitRate(prizeMap)
        );
    }
}
