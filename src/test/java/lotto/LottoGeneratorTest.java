package lotto;

import lotto.model.Lotto;
import lotto.model.service.LottoGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mockStatic;


public class LottoGeneratorTest {

//
//
//
//    @Test
//    public void testCreateSingleLotto(){
//        // Given
//        LottoGenerator lottoGenerator = new LottoGenerator();
//        int lottoQuantity = 1;
//
//        try (MockedStatic<Math> mathMockedStatic = mockStatic(Math.class)) {
//            // 모의(Mockito)로 Math.random() 메서드 호출 결과를 고정된 값으로 설정
//            mathMockedStatic.when(Math::random).thenReturn(0.1);
//
//            // When
//            List<Lotto> lottos = lottoGenerator.createLottos(lottoQuantity);
//
//            // Then
//            assertEquals(lottoQuantity, lottos.size());
//
//            // 추가로, 정확한 Lotto 값도 확인
//            assertEquals(List.of(new Lotto(List.of(5, 10, 14, 19, 23, 28))),
//                    lottos);
//        }
//    }

}
