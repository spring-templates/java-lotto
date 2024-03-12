package controller;

import lotto.controller.LottoController;
import lotto.view.InputManager;
import lotto.view.OutputManager;
import lotto.view.SystemOutputManager;
import lotto.view.UserInputManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static org.mockito.Mockito.when;

public class ControllerTest {

    @DisplayName("정상적인 입력 가정 시스템 통합 테스트")
    @Test
    public void runLottoControllerTest(){
        // Given
        String inputString = "2000\n" + // 구매금액
                "2 10 18 24 5 6\n" + // 당첨 번호
                "20\n"; // 보너스

        ByteArrayInputStream in = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(in);

        Random randomNumberMock = Mockito.mock(Random.class);
        when(randomNumberMock.nextInt(45))
                .thenReturn(1,33,32,31,30,34)
                .thenReturn(1,31,9,17,23,44);

        // When
        InputManager inputManager = new UserInputManager(new Scanner(System.in));
        OutputManager outputManager = new SystemOutputManager();
        LottoController lottoController = new LottoController(inputManager, outputManager, randomNumberMock);

        // 출력을 기대하는 값
        List<String> expectedOutput = Arrays.asList(
                "구입금액을 입력해 주세요.",
                "2개를 구매했습니다.",
                "[2, 31, 32, 33, 34, 35]",
                "[2, 10, 18, 24, 32, 45]",
                "당첨 번호를 입력해 주세요.",
                "보너스 번호를 입력해 주세요.",
                "당첨 통계",
                "---",
                "3개 일치 (5,000원) - 0개",
                "4개 일치 (50,000원) - 1개",
                "5개 일치 (1,500,000원) - 0개",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                "6개 일치 (2,000,000,000원) - 0개",
                "총 수익률은 2500.0%입니다."
        );

        // 표준 출력을 캡처하여 테스트에서 비교
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // 테스트 실행
        lottoController.runGame();

        // 표준 출력을 문자열로 변환하여 테스트에서 비교
        String actualOutput = outContent.toString().trim();
        List<String> actualOutputList = Arrays.asList(actualOutput.split("\n"));

        // 출력 비교
        // Then
        Assertions.assertThat(actualOutputList)
                .isEqualTo(expectedOutput);
    }
}
