package primeNumbers;

import output.Output;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PrintPrimeNumbers {
    Output output;
    public PrintPrimeNumbers(Output output){
        this.output = output;
    }
    public void printPrimeNumbers(List<Integer> numbers) throws IOException {
        ArrayList<String> numbersStringList = new ArrayList<>();
        for(Integer n : numbers) numbersStringList.add(String.valueOf(n));
        String res = String.join(",",numbersStringList);
        output.print(res);
    }
}
