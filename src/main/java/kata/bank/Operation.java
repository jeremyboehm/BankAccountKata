package kata.bank;

import java.time.LocalDateTime;

public class Operation {

    private final OperationType operationType;
    private final LocalDateTime date;
    private final Amount givenAmount;
    private final Amount balance;

    public Operation(OperationType operationType, LocalDateTime date, Amount givenAmount, Amount balance) {
        this.operationType = operationType;
        this.date = date;
        this.givenAmount = givenAmount;
        this.balance = balance;
    }

    public static Operation of(OperationType operationType, LocalDateTime date, Amount givenAmount, Amount balance) {
        return new Operation(operationType, date, givenAmount, balance);
    }
}
