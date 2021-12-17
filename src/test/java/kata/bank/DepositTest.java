package kata.bank;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class DepositTest {

    @Test
    public void should_increase_the_account_balance_to_0_when_the_deposit_is_0() {

        int amount = 0;

        int updatedBalance = Account.deposit(amount);

        Assertions.assertThat(updatedBalance).isEqualTo(0);
    }

    @Test
    public void should_increase_the_account_balance_to_1_when_the_deposit_is_1() {

        int amount = 1;

        int updatedBalance = Account.deposit(amount);

        Assertions.assertThat(updatedBalance).isEqualTo(1);
    }

    @Test
    public void should_increase_the_account_balance_to_2_when_the_deposit_is_2() {

        int amount = 2;

        int updatedBalance = Account.deposit(amount);

        Assertions.assertThat(updatedBalance).isEqualTo(2);
    }
}
