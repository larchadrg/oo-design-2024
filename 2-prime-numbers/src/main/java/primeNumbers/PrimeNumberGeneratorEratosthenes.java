package primeNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeNumberGeneratorEratosthenes implements PrimeNumberGenerator{

    @Override
    public List<Integer> generatePrimeNumbers(int roofLimit) {
        boolean[] unmarkedNumbers = new boolean[roofLimit+1];
        Arrays.fill(unmarkedNumbers, true);
        int rootOfLimit = (int) Math.sqrt(roofLimit);
        for(int i = 2; i<=rootOfLimit; i++){
            if(unmarkedNumbers[i]){
                for(int j = i*i; j<=roofLimit; j=j+i){
                    unmarkedNumbers[j] = false;
                }
            }
        }
        ArrayList<Integer> primeNumbers = new ArrayList<>();
        for(int i = 2; i <= roofLimit; i++){
            if(unmarkedNumbers[i]) primeNumbers.add(i);
        }
        return primeNumbers;
    }
}
