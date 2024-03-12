package lotto.model.service;

import lotto.model.Lotto;
import lotto.model.dto.Money;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    private final Random random;
    // 더 쉬운 테스트를 위해 Random을 주입하는 방식 사용
    public LottoGenerator(Random random){
        this.random = random;
    }
    
    public int countQuentityBasedOnMoney(Money money){
        return money.getMoney()/1000;
    }

    public List<Lotto> createLottos(int lottoQuantity) {
        return IntStream.range(0, lottoQuantity)
                .mapToObj(i -> createSingleLotto())
                .collect(Collectors.toList());
    }

    private Lotto createSingleLotto(){
        Set<Integer> numbers = new HashSet<>();
        while(numbers.size()<=5) {
            int temp = random.nextInt(45) + 1; // 1~45 사이 값 무작위로 추출
            numbers.add(temp);
        }
        return new Lotto(numbers.stream().toList());
    }
}
