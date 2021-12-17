package kata.bank;

import java.util.Objects;

public class Amount {
    private final int value;

    private Amount(int value) {
        this.value = value;
    }

    public static Amount of(int value) {
        return new Amount(value);
    }

    public Amount add(Amount amount) {
        return of(value + amount.value);
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
