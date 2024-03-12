package lotto;

import lotto.controller.LottoController;
import lotto.model.service.LottoGenerator;
import lotto.view.InputManager;
import lotto.view.OutputManager;
import lotto.view.SystemOutputManager;
import lotto.view.UserInputManager;

import java.util.Random;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputManager inputManager = new UserInputManager(new Scanner(System.in));
        OutputManager outputManager = new SystemOutputManager();
        Random random = new Random();

        LottoController lottoController = new LottoController(inputManager, outputManager, random);
        lottoController.runGame();
    }
}
