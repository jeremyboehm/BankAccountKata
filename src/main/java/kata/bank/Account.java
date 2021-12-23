package kata.bank;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private final Amount balance;
    private final Clock clock;
    private final Operations operations;

    private Account(Amount balance, Clock clock) {
        this.balance = balance;
        this.clock = clock;
        this.operations = new Operations(new ArrayList<>(), balance);
    }

    public static Account of(Amount amount, Clock clock) {
        return new Account(amount, clock);
    }

    public Amount deposit(Amount amount) {
        operations.add(OperationType.DEPOSIT, clock.getTime(), amount);
        return balance.add(amount);
    }

    public Amount withdraw(Amount amount) {
        operations.add(OperationType.WITHDRAW, clock.getTime(), amount);
        return balance.subtract(amount);
    }

    public List<Statement> history() {
        return operations.show();
    }
}
