import java.util.Arrays;

public class Game {
    private Card[] cards;
    private CardsGenerator generator = new CardsGenerator();
    private Drum drum = new Drum(1,90);

    private int[] drumLog = new int[90];

    public Game(int numCards) {

        cards = new Card[numCards];

        for (int i = 0; i < cards.length; i++) {
            cards[i] = new Card(generator);
        }

    }

    public void play() {
        playForLine();
        playForBingo();

        showDrumLog();
    }

    public void playForLine() {

        boolean anyLine = false;

        while (drum.ballsRemaining != 0 && !anyLine) {
            int ball = drum.extractBall();
            drumLog[drum.ballsRemaining] = ball;

            for (int j = 0; j < cards.length; j++) {
                cards[j].markNumber(ball);

                if (cards[j].isLine()) {
                    System.out.println("LINE COMPLETED by card n. "+(j+1)+":");
                    System.out.println(cards[j]);
                    anyLine = true;
                }
            }
        }
    }

    public void playForBingo() {
        boolean anyBingo = false;

        while (drum.ballsRemaining != 0 && !anyBingo) {
            int ball = drum.extractBall();
            drumLog[drum.ballsRemaining] = ball;

            for (int j = 0; j < cards.length; j++) {
                cards[j].markNumber(ball);

                if (cards[j].isBingo()) {
                    System.out.println("BINGO by card n. "+(j+1)+":");
                    System.out.println(cards[j]);
                    anyBingo = true;
                }

            }
        }
    }

    private void showDrumLog() {

        System.out.print("Extracted numbers: ");
        for(int i = drumLog.length -1; i > 0; i --) {
            if (!(drumLog[i] == 0)) {
                if (i == drumLog.length -1) {
                    System.out.print(drumLog[i]);
                } else {
                    System.out.print(", " +drumLog[i]);
                }

            }
        }
    }
}
