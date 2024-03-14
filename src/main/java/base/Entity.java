package base;

public abstract class Entity<IN extends InputSchema, OUT extends OutputSchema> {
    protected final Validator<IN, OUT> validator;

    protected Entity(IN in, Validator<IN, OUT> validator) throws IllegalArgumentException {
        this.validator = validator;
        validator.validate(in);
    }

    public abstract OUT toDto();
}
