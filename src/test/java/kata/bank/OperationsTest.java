package kata.bank;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static kata.bank.ClockMock.DEFAULT_TIME;

public class OperationsTest {

    @Test
    public void should_add_a_new_operation() {
        Operations operations = new Operations(new ArrayList<>());

        operations.add(OperationType.DEPOSIT, DEFAULT_TIME, Amount.of(100), Amount.of(100));

        List<Operation> result = operations.show();

        System.out.println(result.get(0).toString());

        Assertions.assertThat(result).hasSize(1);
        Assertions.assertThat(result.get(0)).isEqualTo(Operation.of(OperationType.DEPOSIT, DEFAULT_TIME, Amount.of(100), Amount.of(100)));
    }
}