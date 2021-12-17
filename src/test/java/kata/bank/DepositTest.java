package kata.bank;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class DepositTest {

    @Test
    public void should_increase_the_account_balance_when_a_deposit_is_made() {

        int balance = 0;
        int amount = 0;

        int updatedBalance = Account.deposit(balance, amount);

        Assertions.assertThat(updatedBalance).isEqualTo(0);
    }

    @Test
    public void should_increase_the_account_balance_when_a_deposit_is_made_2() {

        int balance = 0;
        int amount = 1;

        int updatedBalance = Account.deposit(balance, amount);

        Assertions.assertThat(updatedBalance).isEqualTo(1);
    }
}
