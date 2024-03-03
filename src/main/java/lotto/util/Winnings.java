package lotto.util;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum Winnings {
    Fifth("3개 일치",5000,3,0),
    Fourth("4개 일치",50000,4,0),
    Third("5개 일치",1500000,5,0),
    Second("5개 일치, 보너스 볼 일치",30000000,5,1),
    First("6개 일치", 2000000000,6,0);

    private String winningDescription;
    private int winningValue;
    private int winningMatchCount;
    private int bonusMatchCount;

    Winnings(String s, int i,int j, int k) {
        this.winningDescription = s;
        this.winningValue = i;
        this.winningMatchCount = j;
        this.bonusMatchCount=k;
    }

    public static Map<Winnings, Integer> newWinningsMap(){
        HashMap<Winnings, Integer> map = new HashMap<>();
        for(Winnings w : values()){
            map.put(w,0);
        }
        return map;
    }

    public static Winnings valueOfWinningsAndBonus(int winningMatchCount, int bonusMatchCount){
        for(Winnings w : values()){
            if(w.winningMatchCount == winningMatchCount){
                if(winningMatchCount != 5)
                    return w;
                if(w.bonusMatchCount == bonusMatchCount)
                    return w;
            }
        }
        return null;
    }

}
