package base;

public abstract class Generator<IN extends InputSchema, OUT extends OutputSchema> {
    protected Validator<IN> validator;

    public OUT generate(IN in) throws IllegalArgumentException {
        validator.validate(in);
        return getEntity(in).toDto();
    }

    protected abstract Entity<IN, OUT> getEntity(IN in);
}
