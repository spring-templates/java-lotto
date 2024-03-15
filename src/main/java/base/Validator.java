package base;

public interface Validator<T extends Schema> {
    void validate(T input) throws IllegalArgumentException;
}
