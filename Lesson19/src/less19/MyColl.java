package less19;

public class MyColl<T> { // можно задать чтобы Т было обязательно чем-то что наследуюется от Object:
                         // MyColl<T extends Object>
                         //

    private T value;// T может быть чем угодно, и String и Integer и т.д.

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
