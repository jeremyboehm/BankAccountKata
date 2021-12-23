package kata.bank;

import java.util.Objects;

public class Statement {

    private final Operation operation;
    private final Amount balanceBeforeOperation;

    public Statement(Operation operation, Amount balanceBeforeOperation) {
        this.operation = operation;
        this.balanceBeforeOperation = balanceBeforeOperation;
    }

    public static Statement of(Operation operation, Amount balanceBeforeOperation) {
        return new Statement(operation, balanceBeforeOperation);
    }

    public Amount getBalance() {
        return balanceBeforeOperation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Statement statement = (Statement) o;
        return Objects.equals(operation, statement.operation) &&
                Objects.equals(balanceBeforeOperation, statement.balanceBeforeOperation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operation, balanceBeforeOperation);
    }

    @Override
    public String toString() {
        return "Statement{" +
                "operation=" + operation +
                ", balanceBeforeOperation=" + balanceBeforeOperation +
                '}';
    }
}
