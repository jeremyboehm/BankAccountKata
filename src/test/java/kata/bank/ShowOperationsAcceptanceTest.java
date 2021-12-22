package kata.bank;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;

import static kata.bank.ClockMock.DEFAULT_TIME;

public class ShowOperationsAcceptanceTest {

    @Test
    public void should_show_operations() {
        Account account = Account.of(Amount.of(500));

        account.deposit(Amount.of(300));
        account.deposit(Amount.of(50));
        account.withdraw(Amount.of(100));
        account.deposit(Amount.of(20));
        account.withdraw(Amount.of(50));

        Operations operations = account.history();

        Assertions.assertThat(operations).isEqualTo(
                new Operations(Arrays.asList(
                        Operation.of(OperationType.DEPOSIT, DEFAULT_TIME, Amount.of(300), Amount.of(500)),
                        Operation.of(OperationType.DEPOSIT, DEFAULT_TIME, Amount.of(50), Amount.of(800)),
                        Operation.of(OperationType.WITHDRAW, DEFAULT_TIME, Amount.of(100), Amount.of(850)),
                        Operation.of(OperationType.DEPOSIT, DEFAULT_TIME, Amount.of(20), Amount.of(750)),
                        Operation.of(OperationType.WITHDRAW, DEFAULT_TIME, Amount.of(50), Amount.of(770))
                ))
        );
    }
}
