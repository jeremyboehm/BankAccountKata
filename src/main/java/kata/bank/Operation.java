package kata.bank;

import java.time.LocalDateTime;
import java.util.Objects;

public class Operation {

    private final OperationType operationType;
    private final LocalDateTime date;
    private final Amount givenAmount;
    private final Amount balance;

    public Operation(OperationType operationType, LocalDateTime date, Amount givenAmount, Amount balance) {
        this.operationType = operationType;
        this.date = date;
        this.givenAmount = givenAmount;
        this.balance = balance;
    }

    public static Operation of(OperationType operationType, LocalDateTime date, Amount givenAmount, Amount balance) {
        return new Operation(operationType, date, givenAmount, balance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return operationType == operation.operationType &&
                Objects.equals(date, operation.date) &&
                Objects.equals(givenAmount, operation.givenAmount) &&
                Objects.equals(balance, operation.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationType, date, givenAmount, balance);
    }
}
