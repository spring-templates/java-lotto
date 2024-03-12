package service;

import lotto.model.Lotto;
import lotto.model.service.LottoGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

public class LottoGeneratorTest {

    private static Random random;

    @BeforeAll
    @Test
    static void setRandom(){
        random = new Random();
    }

    @DisplayName("랜덤한 로또 생성을 더미로 만들 수 있는지 테스트. 통합 테스트를 위함")
    @Test
    public void dumyRandomLottos(){
        // 한 스레드에서 static 모킹은 한번밖에 못하므로 close하지 않으면 여러 테스트 도중 이미 존재하는 mock이라는 에러가 발생한다.
        // try-resources 구문을 사용하면 자동으로 메모리 해제한다.
        Random randomNumberMock = Mockito .mock(Random.class);
        when(randomNumberMock.nextInt(45)).thenReturn(1)
                .thenReturn(33)
                .thenReturn(32)
                .thenReturn(31)
                .thenReturn(30)
                .thenReturn(34);

        LottoGenerator lottoGenerator = new LottoGenerator(randomNumberMock);
        // When
        List<Lotto> lottos = lottoGenerator.createLottos(1);
        // Then
        Assertions.assertThat(lottos)
                .isEqualTo(List.of(new Lotto(List.of(35,34,33,32,31,2))));
    }

    @DisplayName("로또가 정해진 개수만큼 생성되는지 테스트.")
    @Test
    public void testCreateLottos(){
        LottoGenerator lottoGenerator = new LottoGenerator(random);
        List<Lotto> lottos = lottoGenerator.createLottos(10);
        assertEquals(10, lottos.size());
    }

    @DisplayName("로또 요소가 1에서 45 사이인지 테스트.")
    @Test
    public void testLottosScoope() {
        // Given
        LottoGenerator lottoGenerator = new LottoGenerator(random);
        int lottoQuantity = 10;

        // When
        List<Lotto> lottos = lottoGenerator.createLottos(lottoQuantity);

        // Then
        for (Lotto lotto : lottos) {
            assertThat(lotto.numbers())
                    .allSatisfy( n -> {
                        assertThat(n).isGreaterThan(0);
                        assertThat(n).isLessThan(46);
                    });
        }
    }
}
