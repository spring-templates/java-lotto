package base;

public abstract class Validator<T extends Schema> {
    protected abstract void validate(T t) throws IllegalArgumentException;
}
