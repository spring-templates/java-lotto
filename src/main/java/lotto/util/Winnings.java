package lotto.util;

import lombok.Getter;

@Getter
public enum Winnings {
    First("6개 일치", 2000000000),
    Second("5개 일치, 보너스 볼 일치",30000000),
    Third("5개 일치",30000000),
    Fourth("4개 일치",30000000),
    Fifth("3개 일치",30000000);

    private String winningDescription;
    private int winningValue;

    Winnings(String s, int i) {
        this.winningDescription = s;
        this.winningValue = i;
    }
}
