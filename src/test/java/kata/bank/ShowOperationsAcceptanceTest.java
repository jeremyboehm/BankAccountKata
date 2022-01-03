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
        Amount initBalance = Amount.of(0);
        Account account = Account.of(clock);

        account.deposit(Amount.of(300));
        account.deposit(Amount.of(50));
        account.withdraw(Amount.of(100));
        account.deposit(Amount.of(20));
        account.withdraw(Amount.of(50));

        List<String> result = account.history();

        Assertions.assertThat(result).hasSize(5);
        Assertions.assertThat(result).isEqualTo(Arrays.asList(
                "DEPOSIT, 300, " + DEFAULT_TIME + ", 300",
                "DEPOSIT, 50, " + DEFAULT_TIME + ", 350",
                "WITHDRAW, 100, " + DEFAULT_TIME + ", 250",
                "DEPOSIT, 20, " + DEFAULT_TIME + ", 270",
                "WITHDRAW, 50, " + DEFAULT_TIME + ", 220"
        ));
    }
}
