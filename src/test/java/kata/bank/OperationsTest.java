package kata.bank;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static kata.bank.ClockMock.DEFAULT_TIME;

public class OperationsTest {

    @Test
    public void should_add_a_new_operation() {
        Operations operations = new Operations();

        operations.add(OperationType.DEPOSIT, DEFAULT_TIME, Amount.of(100));

        List<String> result = operations.show();

        Assertions.assertThat(result).hasSize(1);
        Assertions.assertThat(result)
                .isEqualTo(Collections.singletonList(
                        "DEPOSIT, 100, " + DEFAULT_TIME + ", 100"
                ));
    }

    @Test
    public void should_show_operations_with_calculated_balance() {
        Operations operations = new Operations();

        operations.add(OperationType.DEPOSIT, DEFAULT_TIME, Amount.of(100));
        operations.add(OperationType.DEPOSIT, DEFAULT_TIME, Amount.of(500));
        operations.add(OperationType.WITHDRAW, DEFAULT_TIME, Amount.of(250));

        List<String> result = operations.show();

        Assertions.assertThat(result).hasSize(3);
        Assertions.assertThat(result)
                .isEqualTo(Arrays.asList(
                        "DEPOSIT, 100, " + DEFAULT_TIME + ", 100",
                        "DEPOSIT, 500, " + DEFAULT_TIME + ", 600",
                        "WITHDRAW, 250, " + DEFAULT_TIME + ", 350"
                ));
    }
}