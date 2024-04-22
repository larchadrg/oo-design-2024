import org.easymock.EasyMockExtension;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import output.Output;
import primeNumbers.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.easymock.EasyMock.*;

@ExtendWith(EasyMockExtension.class)
public class TestPrimeNumbers {

    @Mock
    private Output output;

    @TestSubject
    private PrintPrimeNumbers printPrimeNumbers = new PrintPrimeNumbers(output);

    @BeforeEach
    public void setUp() throws IOException {
        output.print("2,3,5,7");
        replay(this.output);
    }

    @ParameterizedTest
    @MethodSource("primeNumberGenerators")
    public void testGetPrimeUpTo10(PrimeNumberGenerator generator) throws IOException {
        PrimeNumberSequence primeNumberSequence = new PrimeNumberSequence(generator);
        List<Integer> numbers = primeNumberSequence.primeNumberSequence(10);
        printPrimeNumbers.printPrimeNumbers(numbers);
        verify(output);
    }

    static List<PrimeNumberGenerator> primeNumberGenerators() {
        return Arrays.asList(new PrimeNumberGeneratorLinear(), new PrimeNumberGeneratorEratosthenes());
    }
}
