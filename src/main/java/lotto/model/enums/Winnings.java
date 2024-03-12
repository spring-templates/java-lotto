package lotto.model.enums;

import lombok.Getter;
import java.util.Arrays;

@Getter
public enum Winnings {
    Fail(0,0,false),
    Fifth(5000,3,false),
    Fourth(50000,4,false),
    Third(1500000,5,false),
    Second(30000000,5,true),
    First(2000000000,6,false);

    private int winningValue;
    private int winningMatchCount;
    private boolean bonusMatchCount;

    Winnings(int winningValue,int winningMatchCount, boolean bonusMatchCount) {
        this.winningValue = winningValue;
        this.winningMatchCount = winningMatchCount;
        this.bonusMatchCount = bonusMatchCount;
    }

    // valueOfWinningsAndBonus의 if문 분기를 제거. 대신 Fail에 따른 Output 로직 수정은 필요.
    public static Winnings of(int winningMatchCount, boolean bonusMatch){
        return Arrays.stream(values())
                .filter(it -> (it.winningMatchCount == winningMatchCount &&
                        it.bonusMatchCount == bonusMatch))
                .findAny()
                .orElse(Fail);
    }
}