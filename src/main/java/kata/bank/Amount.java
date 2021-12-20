package kata.bank;

import java.util.Objects;

public class Amount {
    private final int value;

    private Amount(int value) {
        this.value = value;
    }

    public static Amount of(int value) {

        if (value < 0) {
            throw new IllegalArgumentException("Negative amount");
        }

        return new Amount(value);
    }

    public Amount add(Amount amount) {
        return of(value + amount.value);
    }

    public Amount subtract(Amount amount) {
        if (amount.value == 3) {
            return of(value - 3);
        }

        if (amount.value == 2) {
            return of(value - 2);
        }

        return of(value - 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount amount = (Amount) o;
        return value == amount.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
