import java.util.Arrays;

public class Card {
    CardsGenerator cardsGenerator;

    int[][] card = new int[3][5];
    boolean[][] checked = new boolean[3][5];

    public Card(CardsGenerator cardsGenerator) {
        this.cardsGenerator = cardsGenerator;


        for (int i = 0; i < card.length; i++) {
            card[i] = cardsGenerator.getNumbersInRow();
        }

    }

    public void markNumber(int number) {
        for (int i = 0; i < card.length; i++) {
            for (int j = 0; j < card[0].length; j++) {
                if (number == card[i][j]) {
                    checked[i][j] = true;
                }
            }
        }
    }

    public boolean isLine() {

        for (int i = 0; i < checked.length; i++) {
            int tmpPoint = 0;
            for (int j = 0; j < checked[0].length; j++) {
                if (checked[i][j]) {
                    tmpPoint++;
                }
                if (tmpPoint == 5) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isBingo() {
        for (int i = 0; i < checked.length; i++) {
            for (int j = 0; j < checked[0].length; j++) {
                if (!checked[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < card.length; i++) {
            for (int j = 0; j < card[0].length; j++) {
                if (checked[i][j]) {
                    if (j % card[0].length == 0) {
                        stringBuilder.append("["+card[i][j]+"]");
                    } else {
                        stringBuilder.append(", " + "["+card[i][j]+"]");
                    }
                } else {
                    if (j % card[0].length == 0) {
                        stringBuilder.append(card[i][j]);
                    } else {
                        stringBuilder.append(", " + card[i][j]);
                    }
                }
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
