package lotto.view.sout;

import base.view.OutputView;
import java.util.List;
import lotto.model.entity.lotto.LottoOutputDto;
import lotto.model.entity.lotto.LottoPurchaseOutputDto;

public class LottoPurchaseOutputView extends OutputView<LottoPurchaseOutputDto> {
    @Override
    public void render(LottoPurchaseOutputDto dto) {
        List<LottoOutputDto> purchased = dto.purchased();
        headerOnEachRender(purchased);
        purchased.forEach(this::render);
    }

    private void render(LottoOutputDto dto) {
        System.out.println(dto);
    }

    private void headerOnEachRender(List<LottoOutputDto> purchased) {
        System.out.println(purchased.size() + "개를 구매했습니다.");
    }
}
