package primeNumbers;

import java.util.List;

public class PrimeNumberSequence {
    PrimeNumberGenerator generator;

    public PrimeNumberSequence(PrimeNumberGenerator generator){
        this.generator = generator;
    }

    public List<Integer> primeNumberSequence(int roofLimit){
        return generator.generatePrimeNumbers(roofLimit);
    }

}
