package kata.bank;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static kata.bank.ClockMock.DEFAULT_TIME;

public class OperationsTest {

    @Test
    public void should_add_a_new_operation() {
        Operations operations = new Operations(new ArrayList<>(), Amount.of(500));

        operations.add(OperationType.DEPOSIT, DEFAULT_TIME, Amount.of(100));

        List<Statement> result = operations.show();

        Assertions.assertThat(result).hasSize(1);
        Assertions.assertThat(result.get(0))
                .isEqualTo(
                        Statement.of(
                                Operation.of(OperationType.DEPOSIT, DEFAULT_TIME, Amount.of(100)),
                                Amount.of(500)
                        ));
    }

    @Test
    public void should_show_operations_with_calculated_balance() {
        Operations operations = new Operations(new ArrayList<>(), Amount.of(500));

        operations.add(OperationType.DEPOSIT, DEFAULT_TIME, Amount.of(100));
        operations.add(OperationType.DEPOSIT, DEFAULT_TIME, Amount.of(50));
        operations.add(OperationType.WITHDRAW, DEFAULT_TIME, Amount.of(250));

        List<Statement> result = operations.show();

        Assertions.assertThat(result).hasSize(3);
        Assertions.assertThat(result)
                .isEqualTo(Arrays.asList(
                        Statement.of(Operation.of(OperationType.DEPOSIT, DEFAULT_TIME, Amount.of(100)), Amount.of(500)),
                        Statement.of(Operation.of(OperationType.DEPOSIT, DEFAULT_TIME, Amount.of(50)), Amount.of(600)),
                        Statement.of(Operation.of(OperationType.WITHDRAW, DEFAULT_TIME, Amount.of(250)), Amount.of(650))
                ));
    }

    @Test
    public void should_show_operations_with_calculated_balance2() {
        Operations operations = new Operations();

        operations.add(OperationType.DEPOSIT, DEFAULT_TIME, Amount.of(300));
        operations.add(OperationType.DEPOSIT, DEFAULT_TIME, Amount.of(500));
        operations.add(OperationType.WITHDRAW, DEFAULT_TIME, Amount.of(250));

        List<String> result = operations.show2();

        Assertions.assertThat(result).hasSize(3);
        Assertions.assertThat(result)
                .isEqualTo(Arrays.asList(
                        "DEPOSIT, 300, " + DEFAULT_TIME + ", 300",
                        "DEPOSIT, 500, " + DEFAULT_TIME + ", 800",
                        "WITHDRAW, 250, " + DEFAULT_TIME + ", 550"
                        ));
    }
}