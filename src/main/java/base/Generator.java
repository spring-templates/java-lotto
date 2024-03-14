package base;

public abstract class Generator<IN extends InputSchema, OUT extends Record & OutputSchema> {
    public OUT generate(IN in) throws IllegalArgumentException {
        return getEntity(in).toDto();
    }

    protected abstract Entity<IN, OUT> getEntity(IN in);
}
