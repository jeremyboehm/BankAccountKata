package kata.bank;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class WithdrawalAcceptanceTest {

    private final Clock clock = ClockMock.withDefaultTime();

    @Test
    public void should_decrease_balance_by_given_amount() {
        Account account = Account.of(Amount.of(500), clock);
        Amount givenAmount = Amount.of(40);

        Amount result = account.withdraw(givenAmount);

        Assertions.assertThat(result).isEqualTo(Amount.of(460));
    }
}
