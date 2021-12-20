package kata.bank;

import org.junit.Test;
import org.assertj.core.api.Assertions;

public class AmountTest {

    @Test
    public void should_add_given_amount() {
        Amount amount = Amount.of(3);
        Amount givenAmount = Amount.of(2);

        Amount result = amount.add(givenAmount);

        Assertions.assertThat(result).isEqualTo(Amount.of(5));
    }

    @Test
    public void should_subtract_given_amount() {
        Amount amount = Amount.of(3);
        Amount givenAmount = Amount.of(2);

        Amount result = amount.subtract(givenAmount);

        Assertions.assertThat(result).isEqualTo(Amount.of(1));
    }

    @Test
    public void negative_amount_not_allowed() {
        Assertions.assertThatThrownBy(() -> Amount.of(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Negative amount");
    }

    @Test
    public void withdrawal_amount_must_be_greater_than_balance_amount() {
        Amount amount = Amount.of(10);
        Amount givenAmount = Amount.of(100);

        Assertions.assertThatThrownBy(() -> amount.subtract(givenAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Withdrawal amount must be greater than balance amount");
    }
}