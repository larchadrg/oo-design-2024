package bowling;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BowlingTests {

    private Game g;

    @BeforeEach
    protected void setUp() {
        g = new Game();
    }

    @Test
    public void testGutterGame() {
        rollMany(0,20);
        assertThat(g.score()).isEqualTo(0);
    }

    @Test
    public void testAllOnes() {
        rollMany(1,20);
        assertThat(g.score()).isEqualTo(20);
    }

    @Test
    public void testOneSpare() {
        rollSpare();
        g.roll(3);
        rollMany(0,17);
        assertThat(g.score()).isEqualTo(16);
    }

    @Test
    public void testOneStrike() {
        rollStrike();
        g.roll(3);
        g.roll(4);
        rollMany(0,16);
        assertThat(g.score()).isEqualTo(24);
    }
    private void rollMany(int pins, int rolls) {
        for(int i=0;i<rolls;i++) g.roll(pins);
    }

    private void rollSpare(){
        g.roll(5);
        g.roll(5);
    }

    private void rollStrike(){
        g.roll(10);
    }


    @Test
    public void testMaxScore(){
        for(int i=0;i<12;i++){
            rollStrike();
        }
        int score = g.score();
        assertThat(score).isEqualTo(300);
    }

    @Test 
    public void testAllSpares(){
        for(int i=0;i<10;i++){
            rollSpare();
        }
        g.roll(5);
        int score = g.score();
        assertThat(score).isEqualTo(150);
    }

    @Test
    public void invalidRoll() {
        IllegalArgumentException  exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    g.roll(12);
                });
        assertThat(exception.getMessage().equals("Illegal pins argument"));
    }

    @Test
    public void invalidMultipleRolls() {
        IllegalArgumentException  exception = assertThrows(IllegalArgumentException.class,
                () -> {
                    g.roll(2);
                    g.roll(9);
                    g.score(); 
                });
        assertThat(exception.getMessage().equals("Illegal pins argument"));
    }
    @Test
    public void testSpare() {
        g.roll(1);
        g.roll(9);
        g.roll(7);
        int score = g.score();
        assertThat(score).isEqualTo(24);
    }
    @Test
    public void testStrike() {
        g.roll(10);
        g.roll(7);
        g.roll(1);
        int score = g.score();
        assertThat(score).isEqualTo(26);
    }
    @Test
    public void testConsecutiveStrikes() {
        g.roll(10); //22
        g.roll(10); // 15
        g.roll(2);
        g.roll(3);
        g.roll(6);
        g.roll(1);
        assertThat(g.score()).isEqualTo(49);
    }

}
