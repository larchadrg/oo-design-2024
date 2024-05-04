package decorator.starbuzz;

public class Latte extends Beverage{
    public Latte(BeverageSize size){
        description = "Latte";
        this.size = size;
    }

    @Override
    public double cost() {
        return 1.5;
    }
}
