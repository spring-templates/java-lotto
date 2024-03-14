package base;

public abstract class Entity<IN extends InputSchema, OUT extends OutputSchema> {

    protected Validator<IN, OUT> validator;
    protected Entity(IN in, Validator<IN, OUT> validator) {
        this.validator = validator;
        this.validator.validate(in);
    }

    protected void validate(OUT out) throws IllegalArgumentException {
        this.validator.validate(out);
    }


    protected abstract OUT toDto();
}
