package kata.bank;

public class Account {

    private final int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public int deposit(int amount) {
        return this.balance + amount;
    }
}
