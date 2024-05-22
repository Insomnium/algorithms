package net.ins.edu.concurrency;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FJPParallelizationTest {

    @Test
    public void shouldSumIntCollection() {
        var input = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        assertEquals(
                sum(input),
                new FJPParallelization.FJPArraySum(input).compute()
        );
    }

    @ParameterizedTest(name = "factorial({0}) == {1}")
    @CsvSource({
            "0,1",
            "1,1",
            "2,2",
            "3,6",
            "10,3628800"
    })
    public void shouldComputeFactorial(
            int n,
            int expected
    ) {
        assertEquals(expected, factorial(n)); // just for fun
        assertEquals(expected, new FJPParallelization.FJPFactorial(n).compute());
    }

    private int sum(List<Integer> input) {
        return input.stream().mapToInt(i -> i).sum();
    }

    private int factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }
}
