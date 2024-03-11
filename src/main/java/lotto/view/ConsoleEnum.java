package lotto.view;

public enum ConsoleEnum {
    PURCHASE_MONEY_INPUT_HEADER("구입금액을 입력해 주세요."),
    WINNING_NUMBER_INPUT_HEADER("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_INPUT_HEADER("보너스 볼을 입력해 주세요."),
    LOTTO_OUTPUT_HEADER_FORMAT("%d개를 구매했습니다.\n"),
    STATISTICS_OUTPUT_HEADER("당첨 통계\n---"),
    PRIZE_MATCHED_NUMBER_OUTPUT_FORMAT("%d개 일치"),
    PROFIT_RATE_OUTPUT_FORMAT("총 수익률은 %.1f%%입니다."),
    STATISTICS_BONUS_OUTPUT_FORMAT(", 보너스 볼 일치"),
    PRIZE_WITH_CURRENCY_OUTPUT_FORMAT(" (%,d원)"),
    PRIZE_NUMBER_OUTPUT_FORMAT(" - %d개"),
    ;

    private final String value;

    ConsoleEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
