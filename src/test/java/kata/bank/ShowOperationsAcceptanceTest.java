package kata.bank;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static kata.bank.ClockMock.DEFAULT_TIME;

public class ShowOperationsAcceptanceTest {

    private final Clock clock = ClockMock.withDefaultTime();

    @Test
    public void should_show_operations() {
        Amount initBalance = Amount.of(500);
        Account account = Account.of(initBalance, clock);

        account.deposit(Amount.of(300));
        account.deposit(Amount.of(50));
        account.withdraw(Amount.of(100));
        account.deposit(Amount.of(20));
        account.withdraw(Amount.of(50));

        List<Statement> statements = account.history();

        Assertions.assertThat(statements).isEqualTo(Arrays.asList(
                        Statement.of(Operation.of(OperationType.DEPOSIT, DEFAULT_TIME, Amount.of(300)), Amount.of(500)),
                        Statement.of(Operation.of(OperationType.DEPOSIT, DEFAULT_TIME, Amount.of(50)), Amount.of(800)),
                        Statement.of(Operation.of(OperationType.WITHDRAW, DEFAULT_TIME, Amount.of(100)), Amount.of(850)),
                        Statement.of(Operation.of(OperationType.DEPOSIT, DEFAULT_TIME, Amount.of(20)), Amount.of(750)),
                        Statement.of(Operation.of(OperationType.WITHDRAW, DEFAULT_TIME, Amount.of(50)), Amount.of(770))
                )
        );
    }
}
