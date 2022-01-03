package kata.bank;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private Amount balance;
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
        balance = balance.add(amount);
        return balance;
    }

    public Amount withdraw(Amount amount) {
        operations.add(OperationType.WITHDRAW, clock.getTime(), amount);
        balance = balance.subtract(amount);
        return balance;
    }

    public List<Statement> history() {
        return operations.show();
    }

    public List<String> history2() {
        return operations.show2();
    }
}
