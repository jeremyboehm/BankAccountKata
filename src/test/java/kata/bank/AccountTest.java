package kata.bank;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class AccountTest {

    private final Clock clock = ClockMock.withDefaultTime();

    @Test
    public void should_increase_balance_when_deposit() {
        Account account = Account.of(Amount.of(500), clock);
        Amount givenAmount = Amount.of(100);

        Amount result = account.deposit(givenAmount);

        Assertions.assertThat(result).isEqualTo(Amount.of(600));
    }

    @Test
    public void should_decrease_balance_when_withdraw() {
        Account account = Account.of(Amount.of(500), clock);
        Amount givenAmount = Amount.of(100);

        Amount result = account.withdraw(givenAmount);

        Assertions.assertThat(result).isEqualTo(Amount.of(400));
    }
}