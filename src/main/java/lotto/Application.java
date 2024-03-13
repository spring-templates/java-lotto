package lotto;

import java.util.List;
import lotto.model.entity.lotto.ILottoInputDto;
import lotto.model.entity.lotto.ILottoOutputDto;
import lotto.model.entity.lotto.LottoGenerator;

public class Application {
    public static void main(String[] args) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        LottoInputDto lottoInput = new LottoInputDto(List.of(1, 2, 3, 4, 5, 6));
        ILottoOutputDto lottoOutput = lottoGenerator.generate(lottoInput);
        System.out.println(lottoOutput.numbers());
    }

    private record LottoInputDto(List<Integer> numbers) implements ILottoInputDto {
    }
}
