package kata.bank;

import java.util.List;

public class Account {

    private final Clock clock;
    private final Operations operations;

    private Account(Clock clock) {
        this.clock = clock;
        this.operations = new Operations();
    }

    public static Account of(Clock clock) {
        return new Account(clock);
    }

    public void deposit(Amount amount) {
        operations.add(OperationType.DEPOSIT, clock.getTime(), amount);
    }

    public void withdraw(Amount amount) {
        operations.add(OperationType.WITHDRAW, clock.getTime(), amount);
    }

    public List<String> history() {
        return operations.show();
    }
}
