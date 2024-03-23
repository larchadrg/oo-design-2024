package StringCalculator;
import java.util.ArrayList;

import static StringCalculator.StringCalculatorAux.*;

public class StringCalculator {
    public static int add(String string){
        if(string.isEmpty()) return 0;

        String delimiter = getDelimiter(string);
        int opStartIndex = getOperationStartIndex(string);
        ArrayList<Integer> adderOperatorPositions = delimiterPositions(string, opStartIndex, delimiter);
        ArrayList<Integer> numbers = stringToNumbers(string, opStartIndex,delimiter,adderOperatorPositions);

        ArrayList<Integer> negativeNumbers = getNegativeNumbers(numbers);
        if(!negativeNumbers.isEmpty()) throw new IllegalArgumentException("Negative numbers are not allowed: "+ negativeNumbers);

        int total = 0;
        for (Integer number : numbers) total += number;
        return total;
    }
}