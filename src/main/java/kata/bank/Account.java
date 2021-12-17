package kata.bank;

public class Account {

    private final Amount balance;

    public Account(Amount balance) {
        this.balance = balance;
    }

    public Amount deposit(Amount amount) {
        return balance.add(amount);
    }
}
