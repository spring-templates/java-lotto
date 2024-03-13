package base;

public abstract class Entity<IN extends InputSchema, OUT extends OutputSchema> {

    protected Entity(IN in) throws IllegalArgumentException {
        validate(in);
    }

    protected abstract void validate(IN in) throws IllegalArgumentException;

    public abstract OUT toDto();
}
