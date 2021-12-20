package kata.bank;

public class Account {

    private final Amount balance;

    private Account(Amount balance) {
        this.balance = balance;
    }

    public static Account of(Amount amount) {
        return new Account(amount);
    }

    public Amount deposit(Amount amount) {
        return balance.add(amount);
    }

    public Amount withdraw(Amount amount) {
        return balance.subtract(amount);
    }
}
