package kata.bank;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class DepositAcceptanceTest {

    @Test
    public void should_increase_balance_by_given_amount() {
        Account account = Account.of(Amount.of(500));
        Amount givenAmount = Amount.of(40);

        Amount result = account.deposit(givenAmount);

        Assertions.assertThat(result).isEqualTo(Amount.of(540));
    }
}
