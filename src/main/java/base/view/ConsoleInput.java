package base.view;

import base.model.Schema;
import base.model.Validator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public abstract class ConsoleInput<IN extends Schema> {

    private static final Scanner scanner = new Scanner(System.in);
    private final View<IN> view;
    private final Validator<IN> validator;

    protected ConsoleInput(View<IN> view, Validator<IN> validator) {
        this.view = view;
        this.validator = validator;
    }

    public final IN tryInput() throws IllegalArgumentException {
        IN res;
        try {
            String input = scanner.nextLine();
            res = parseDto(input);
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        validator.validate(res);
        return res;
    }

    public final IN getInput() {
        while (true) {
            printInputHeader();
            try {
                return tryInput();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    protected abstract IN parseDto(String in) throws IllegalArgumentException;

    private void printInputHeader() {
        view.header();
    }
}
