package StringCalculator;
import java.util.ArrayList;

import static StringCalculator.StringCalculatorAux.*;

public class StringCalculator {
    public static int add(String string) throws IllegalArgumentException{
        if(string.isEmpty()) return 0;
        String delimiter = getDelimiter(string);
        int opStartIndex = getOperationStartIndex(string);
        ArrayList<Integer> adderOperatorPositions = delimiterPositions(string, opStartIndex, delimiter);
        ArrayList<Integer> numbers = stringToNumbers(string, opStartIndex,delimiter,adderOperatorPositions);
        return addNumberList(numbers);
    }
}