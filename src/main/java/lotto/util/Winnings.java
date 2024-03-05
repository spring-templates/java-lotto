package lotto.util;

import lombok.Getter;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Getter
public enum Winnings {
    Fifth("3개 일치",5000,3,false),
    Fourth("4개 일치",50000,4,false),
    Third("5개 일치",1500000,5,false),
    Second("5개 일치, 보너스 볼 일치",30000000,5,true),
    First("6개 일치", 2000000000,6,false);

    private String winningDescription;
    private int winningValue;
    private int winningMatchCount;
    private boolean bonusMatchCount;

    Winnings(String s, int i,int j, boolean k) {
        this.winningDescription = s;
        this.winningValue = i;
        this.winningMatchCount = j;
        this.bonusMatchCount=k;
    }

    public static Map<Winnings, Integer> newWinningsMap(){
        HashMap<Winnings, Integer> map = new LinkedHashMap<>(); // 입력 순서를 보장하면서 Map을 사용할 수 있는 자료형
        for(Winnings w : values()){
            map.put(w,0);
        }
        return map;
    }

    public static Winnings valueOfWinningsAndBonus(int winningMatchCount, boolean bonusMatch){
        for(Winnings w : values()){
            if(w.winningMatchCount == winningMatchCount){
                if(winningMatchCount != 5)
                    return w;
                if(w.bonusMatchCount == bonusMatch)
                    return w;
            }
        }
        return null;
    }

}
