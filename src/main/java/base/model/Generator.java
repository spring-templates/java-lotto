package base.model;

import base.InputSchema;
import base.OutputSchema;

public abstract class Generator<IN extends InputSchema, OUT extends Record & OutputSchema> {
    final public OUT generate(IN in) throws IllegalArgumentException {
        return getEntity(in).toDto();
    }

    protected abstract Entity<IN, OUT> getEntity(IN in);
}
