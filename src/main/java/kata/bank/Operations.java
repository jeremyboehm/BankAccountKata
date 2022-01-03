package kata.bank;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Operations {

    private final List<Operation> operations;

    public Operations() {
        this.operations = new ArrayList<>();
    }

    public void add(OperationType operationType, LocalDateTime date, Amount givenAmount) {
        this.operations.add(Operation.of(operationType, date, givenAmount));
    }

    public List<String> show() {
        Amount updatedBalance = Amount.of(0);
        List<String> operationsToShow = new ArrayList<>();

        for (Operation operation : this.operations) {
            if (operation.getType().equals(OperationType.DEPOSIT)) {
                updatedBalance = updatedBalance.add(operation.getAmount());
            } else {
                updatedBalance = updatedBalance.subtract(operation.getAmount());
            }
            operationsToShow.add(operation.getType() + ", " + operation.getAmount().getValue() + ", " + operation.getDate() + ", " + updatedBalance.getValue());
        }
        return operationsToShow;
    }
}
