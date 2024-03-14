package base;

public abstract class Validator<IN extends InputSchema, OUT extends OutputSchema> {
    public abstract void validate(IN in) throws IllegalArgumentException;

    public abstract void validate(OUT out) throws IllegalArgumentException;
}
