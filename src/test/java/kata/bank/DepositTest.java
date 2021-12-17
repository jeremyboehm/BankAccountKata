package kata.bank;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class DepositTest {

    @Test
    public void should_increase_the_account_balance_from_3_to_5_when_the_deposit_is_2() {

        int balance = 3;
        int amount = 2;

        int updatedBalance = Account.deposit(balance, amount);

        Assertions.assertThat(updatedBalance).isEqualTo(5);
    }
}
