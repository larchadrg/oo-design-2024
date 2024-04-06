package stringCalculator;

import StringCalculator.StringCalculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTests {
    @ParameterizedTest
    @ValueSource(strings = {""})
    public void testAddEmpty(String string){
        int res = StringCalculator.add(string);
        assertThat(res).isEqualTo(0);
    }

    @Test
    public void testAdd3(){
        int res = StringCalculator.add("3");
        assertThat(res).isEqualTo(3);
    }
    @Test
    public void testAdd361(){
        int res = StringCalculator.add("361");
        assertThat(res).isEqualTo(361);
    }

    @Test
    public void testAdd3Plus5(){
        int res = StringCalculator.add("3,5");
        assertThat(res).isEqualTo(8);
    }

    @Test
    public void testAdd34Plus521(){
        int res = StringCalculator.add("34,521,410");
        assertThat(res).isEqualTo(34+521+410);
    }

    @Test
    public void testAddWithNewlineAndComma(){
        int res = StringCalculator.add("1\n2,3");
        assertThat(res).isEqualTo(6);
    }

    @Test
    public void testAddWithDifferentDelimiter(){
        int res = StringCalculator.add("//+\n24+334");
        assertThat(res).isEqualTo(358);
    }

    @Test
    public void testAddWithLargeDelimiter(){
        int res = StringCalculator.add("//++\n24++334");
        assertThat(res).isEqualTo(358);
    }

    @Test
    public void testAddNegativeNumbers(){
        int res = StringCalculator.add("22,-3");
        assertThat(res).isEqualTo(19);
    }
    @Test
    public void testExceptionNegativeNumber(){
        int res = StringCalculator.add("-3");
        assertThat(res).isEqualTo(-3);
    }
}
