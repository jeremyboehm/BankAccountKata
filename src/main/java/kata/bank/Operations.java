package kata.bank;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Operations {

    private final List<Operation> operations;
    private final Amount initBalance;

    public Operations(List<Operation> operations, Amount initBalance) {
        this.operations = operations;
        this.initBalance = initBalance;
    }

    public void add(OperationType operationType, LocalDateTime date, Amount givenAmount) {
        this.operations.add(Operation.of(operationType, date, givenAmount));
    }

    public List<Statement> show() {
        List<Statement> statements = new ArrayList<>();
        statements.add(Statement.of(operations.get(0), initBalance));

        for (int i = 1; i < operations.size(); i++) {
            if (operations.get(i-1).getType().equals(OperationType.DEPOSIT)) {
                statements.add(Statement.of(operations.get(i), statements.get(i-1).getBalance().add(operations.get(i-1).getAmount())));
            } else {
                statements.add(Statement.of(operations.get(i), statements.get(i-1).getBalance().subtract(operations.get(i-1).getAmount())));
            }
        }

        return statements;
    }
}
