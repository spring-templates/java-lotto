package base.controller;

import base.InputSchema;
import base.view.InputView;
import java.util.Scanner;

public abstract class ConsoleInput<IN extends InputSchema> {
    private final InputView<IN> view;
    private final Scanner scanner = new Scanner(System.in);

    protected ConsoleInput(InputView<IN> view) {
        this.view = view;
    }

    public final IN getInput() {
        while (true) {
            printInputHeader();
            try {
                return getDto(consoleIn());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    protected abstract IN getDto(String in) throws IllegalArgumentException;

    protected String consoleIn() {
        return scanner.nextLine();
    }

    protected void printInputHeader() {
        view.header();
    }
}
