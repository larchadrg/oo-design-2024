public abstract class PrimeNumbers{
    public final void show(int amount){
        List<Integer> primeNumbers = generatePrimeNumbers(amount); 
        for(Integer n: primeNumbers){
            System.out.println(n); 
        }
    }

    public List<Integer> generatePrimeNumbers(int amount){

    }
}