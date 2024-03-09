package lotto.util;

import lombok.Getter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Getter
public enum Winnings {
    Fail(0,0,false),
    Fifth(5000,3,false),
    Fourth(50000,4,false),
    Third(1500000,5,false),
    Second(30000000,5,true),
    First(2000000000,6,false);

    private final int winningValue;
    private final int winningMatchCount;
    private final boolean bonusMatchCount;

    Winnings(int i,int j, boolean k) {
        this.winningValue = i;
        this.winningMatchCount = j;
        this.bonusMatchCount=k;
    }

    // valueOfWinningsAndBonus의 if문 분기를 제거. 대신 Fail에 따른 로직 수정은 필요.
    public static Winnings of(int winningMatchCount, boolean bonusMatch){
        return Arrays.stream(values())
                .filter(it -> (it.winningMatchCount == winningMatchCount &&
                        it.bonusMatchCount == bonusMatch))
                .findAny()
                .orElse(Fail);
    }

//    public static Map<Winnings, Integer> newWinningsMap(){
//        HashMap<Winnings, Integer> map = new LinkedHashMap<>(); // 입력 순서를 보장하면서 Map을 사용할 수 있는 자료형
//        for(Winnings w : values()){
//            map.put(w,0);
//        }
//        return map;
//    }

//    public static Winnings valueOfWinningsAndBonus(int winningMatchCount, boolean bonusMatch){
//        for(Winnings w : values()){
//            if(w.winningMatchCount == winningMatchCount){
//                if(winningMatchCount != 5)
//                    return w;
//                if(w.bonusMatchCount == bonusMatch)
//                    return w;
//            }
//        }
//        return null;
//    }
}
