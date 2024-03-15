package base.model;

import base.InputSchema;
import base.OutputSchema;

public abstract class ModelValidator<IN extends InputSchema, OUT extends OutputSchema> {
    public abstract void validate(IN in) throws IllegalArgumentException;

    public abstract void validate(OUT out) throws IllegalArgumentException;
}
