package starbuzz;

import decorator.starbuzz.*;
import org.junit.jupiter.api.Test;

import static decorator.starbuzz.BeverageSize.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBeverage {
    private Beverage b;
    @Test
    public void testSimpleEspresso(){
        b = new Espresso(MEDIUM); //1.99
        assertEquals(1.99, b.cost());
        assertEquals("Espresso", b.getDescription());
        assertEquals(MEDIUM, b.getSize());
    }

    @Test
    public void testSmallDoubleMochaHouseBlend(){
        b = new Mocha(new Mocha(new HouseBlend(SMALL))); //0.89+ 0.20
        assertEquals(1.09, b.cost());
        assertEquals("House Blend Coffee, Mocha, Mocha", b.getDescription());
        assertEquals(SMALL, b.getSize());
    }

    @Test
    public void testBigDoubleMochaSoyLatteWithWhip(){
        b = new Mocha(new Mocha(new Soy(new Whip(new Latte(BIG))))); //1.5+.4+.25=2.15
        assertEquals(2.15, b.cost());
        assertEquals("Latte, Whip, Soy, Mocha, Mocha", b.getDescription());
        assertEquals(BIG, b.getSize());
    }

    @Test
    public void testDecafWithMilk(){
        b = new Milk(new Decaf(MEDIUM));
    }
}
