package base.model;

import base.InputSchema;
import base.OutputSchema;

public abstract class Entity<IN extends InputSchema, OUT extends OutputSchema> {
    protected final ModelValidator<IN, OUT> modelValidator;

    protected Entity(IN in, ModelValidator<IN, OUT> modelValidator) throws IllegalArgumentException {
        this.modelValidator = modelValidator;
        modelValidator.validate(in);
    }

    public abstract OUT toDto();
}
