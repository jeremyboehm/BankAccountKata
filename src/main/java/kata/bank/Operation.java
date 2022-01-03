package kata.bank;

import java.time.LocalDateTime;
import java.util.Objects;

public class Operation {

    private final OperationType operationType;
    private final LocalDateTime date;
    private final Amount givenAmount;

    public Operation(OperationType operationType, LocalDateTime date, Amount givenAmount) {
        this.operationType = operationType;
        this.date = date;
        this.givenAmount = givenAmount;
    }

    public static Operation of(OperationType operationType, LocalDateTime date, Amount givenAmount) {
        return new Operation(operationType, date, givenAmount);
    }

    public OperationType getType() {
        return operationType;
    }

    public Amount getAmount() {
        return givenAmount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return operationType == operation.operationType &&
                Objects.equals(date, operation.date) &&
                Objects.equals(givenAmount, operation.givenAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationType, date, givenAmount);
    }
}
