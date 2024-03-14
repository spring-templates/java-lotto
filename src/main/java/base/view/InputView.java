package base.view;

import base.InputSchema;

public abstract class InputView<IN extends InputSchema> {
    public InputView() {
        header();
    }
    protected abstract void header();
}
