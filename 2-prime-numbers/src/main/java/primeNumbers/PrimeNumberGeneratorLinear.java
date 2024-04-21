package primeNumbers;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumberGeneratorLinear implements PrimeNumberGenerator{
    private boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    @Override
    public List<Integer> generatePrimeNumbers(int roofLimit) {
        List<Integer> primeNumbers = new ArrayList<>();
        for (int i = 2; i <= roofLimit; i++) {
            if (isPrime(i)) primeNumbers.add(i);
        }
        return primeNumbers;
    }
}
