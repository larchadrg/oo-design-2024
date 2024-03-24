package bowling;

public class Game{
    private final int[] rolls;
    private int currentRoll;
    private int totalScore;

    public Game(){
        totalScore = 0;
        int MAX_ROLLS = 21;
        rolls = new int[MAX_ROLLS];
        currentRoll = 0;
    }

    void roll(int pins) {
        rolls[currentRoll] = pins;
        currentRoll++;
    }

    /** @return  total score of the game*/
    int score(){
        int frameIndex = 0;
        int TOTAL_FRAMES = 10;
        for(int frame = 1; frame<= TOTAL_FRAMES; frame++) {
            if(isStrike(frameIndex)){
                totalScore+= 10 + strikeBonus(frameIndex);
                frameIndex++;
            }
            else if (isSpare(frameIndex)) {
                totalScore += 10 + spareBonus(frameIndex);
                frameIndex += 2;
            } else {
                totalScore += sumOfPinsInFrame(frameIndex);
                frameIndex += 2;
            }
        }
        return totalScore;
    }

    private boolean isSpare(int frameIndex){
        return rolls[frameIndex] + rolls[frameIndex+1] == 10;
    }
    private boolean isStrike(int frameIndex){
        return rolls[frameIndex] == 10;
    }

    private int sumOfPinsInFrame(int frameIndex){
        return rolls[frameIndex] + rolls[frameIndex+1];
    }
    private int spareBonus(int frameIndex){
        return rolls[frameIndex+2];
    }
    private int strikeBonus(int frameIndex){
        return rolls[frameIndex+1] + rolls[frameIndex+2];
    }
}