package base.controller;

import base.InputSchema;
import base.OutputSchema;
import base.view.InputView;
import base.view.OutputView;

public abstract class Mediator<IN extends InputSchema, OUT extends Record & OutputSchema> {
    private final InputView<IN> inputView;
    private final OutputView<OUT> outputView;

    public Mediator(InputView<IN> inputView, OutputView<OUT> outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    protected IN getInput() {
        while (true) {
            printInputHeader();
            try {
                return null;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    abstract protected OUT get();

    protected void printInputHeader() {
        inputView.header();
    }

    protected void printOutput(OUT out) {
        outputView.render(out);
    }
}
