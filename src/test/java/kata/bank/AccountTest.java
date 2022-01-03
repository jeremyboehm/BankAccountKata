package kata.bank;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static kata.bank.ClockMock.DEFAULT_TIME;

public class AccountTest {

    private final Clock clock = ClockMock.withDefaultTime();

    @Test
    public void should_show_operations_history() {
        Account account = Account.of(clock);

        account.deposit(Amount.of(500));
        account.withdraw(Amount.of(100));

        List<String> result = account.history();

        Assertions.assertThat(result).hasSize(2);
        Assertions.assertThat(result).isEqualTo(Arrays.asList(
                "DEPOSIT, 500, " + DEFAULT_TIME + ", 500",
                "WITHDRAW, 100, " + DEFAULT_TIME + ", 400"
        ));
    }
}