package base.view;

import base.OutputSchema;

public abstract class OutputView<OUT extends Record & OutputSchema> {
    protected OutputView() {
        header();
    }

    public abstract void render(OUT out);

    protected void header() {
    }
}
