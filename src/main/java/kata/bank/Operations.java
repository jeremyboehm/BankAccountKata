package kata.bank;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Operations {

    private final List<Operation> operations;

    public Operations(List<Operation> operations) {
        this.operations = operations;
    }

    public void add(OperationType operationType, LocalDateTime date, Amount givenAmount, Amount balance) {
        this.operations.add(Operation.of(operationType, date, givenAmount, balance));
    }

    public List<Operation> show() {
        return new ArrayList<>(operations);
    }
}
