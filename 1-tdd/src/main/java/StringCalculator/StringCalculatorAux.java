package StringCalculator;
import java.util.ArrayList;

public class StringCalculatorAux {
    public static ArrayList<Integer> delimiterPositions(String string, int indexStart, String delimiter){
        ArrayList<Integer> delimiterPositions = new ArrayList<>();
        int i = indexStart;
        while (i<string.length()){
            if(string.charAt(i) == '\n'){
                delimiterPositions.add(i);
                i++;
            } else {
                if (i+delimiter.length() >= string.length()) return delimiterPositions;
                String nextSubstring = string.substring(i,i+delimiter.length());
                if(isDelimiter(nextSubstring,delimiter)) delimiterPositions.add(i);
                i += delimiter.length();
            }
        }
        return delimiterPositions;
    }

    private static boolean isDelimiter(String string, String delimiter){
        return string.equals(delimiter);
    }

    public static int subStringToInt(String string, int startIndex, int endIndex){
        int numberValue = 0;
        int exponent = 0;
        boolean isNegative = string.charAt(startIndex) == '-';
        if(isNegative) startIndex++;
        for(int position = endIndex-1; position>=startIndex;position--){
            int charValue = string.charAt(position);
            int digitValue = charValue - '0';
            numberValue += (int) (digitValue * Math.pow(10,exponent));
            exponent++;
        }
        if (isNegative) return numberValue * -1; else return numberValue;
    }

    public static String getDelimiter(String string){
        if(string.length()<4) return ",";
        char c1 = string.charAt(0);
        char c2 = string.charAt(1);
        if(c1 == '/' && c2== '/'){
            int lengthDelimiter = 0;
            while(string.charAt(lengthDelimiter+2) != '\n') lengthDelimiter++;
            return String.copyValueOf(string.toCharArray(),2,lengthDelimiter);
        } else return ",";
    }

    public static int getOperationStartIndex(String string){
        if(string.length()<4) return 0;
        char c1 = string.charAt(0);
        char c2 = string.charAt(1);
        if(c1 == '/' && c2== '/') {
            int indexDelimiter = 2;
            while (string.charAt(indexDelimiter) != '\n') indexDelimiter++;
            return indexDelimiter+1;
        } else return 0;
    }

    public static ArrayList<Integer> stringToNumbers(String string, int opStartIndex, String delimiter, ArrayList<Integer> adderOperatorPositions) {
        ArrayList<Integer> numbers = new ArrayList<>();
        if(string.isEmpty()) return numbers;
        int start_index = opStartIndex;
        for (Integer adderOperatorPosition : adderOperatorPositions) {
            int num = subStringToInt(string, start_index, adderOperatorPosition);
            numbers.add(num);
            start_index = adderOperatorPosition + delimiter.length();
        }
        int lastNumber = subStringToInt(string, start_index,string.length());
        numbers.add(lastNumber);
        return numbers;
    }

    public static ArrayList<Integer> getNegativeNumbers(ArrayList<Integer> numbers){
        ArrayList<Integer> negNumbers = new ArrayList<>();
        for(int n: numbers) if(n < 0) negNumbers.add(n);
        return negNumbers;
    }
}
