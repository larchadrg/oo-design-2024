package bowling;

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
        assertThat(g.score()).isEqualTo(10+3*2);
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
}
