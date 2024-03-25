package output;

import fizzbuzz.PrintFizzBuzz;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.easymock.EasyMock.*;

public class OutputTests {

    @Test
    public void testPrintFizzBuzz() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        MockOutput mock = new MockOutput();
        PrintFizzBuzz printer = new PrintFizzBuzz(mock);
        printer.printFizzBuzz(numbers);
        assertThat(mock.isInvoked()).isTrue();
    }

    @Test
    public void testPrintFizzBuzzEasyMock() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        // Crear objetos
        Output mock = mock(Output.class);

        // Especificar comportamiento esperado
        mock.print("1,2,Fizz,4,Buzz");
        replay(mock);

        PrintFizzBuzz printer = new PrintFizzBuzz(mock);
        printer.printFizzBuzz(numbers);

        // Verificar que se ejercita el comportamiento esperado
        verify(mock);
    }



}
