package lotto.model.service;

import lombok.AllArgsConstructor;
import lotto.model.Customer;
import lotto.model.Lotto;
import lotto.model.Money;
import lotto.view.InputManager;
import lotto.view.OutputManager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@AllArgsConstructor
public class LottoGenerator {
    
    public int countLottosBasedOnAmount(Money money){
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
            int temp = (int) (Math.random() * 45 + 1); // 1~45 사이 값 무작위로 추출
            numbers.add(temp);
        }
        return new Lotto(numbers.stream().toList());
    }
}
