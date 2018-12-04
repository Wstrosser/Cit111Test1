
/*  Ace Free spin 15
    3 of a kind 5
    Royals 4
    Straight 3
    Suit 2
    Color 1
 */
public class Slot {
    public static String text = " ";
    public static int spinLeft = 500;
    private static CardSuits[] reelSuit = new CardSuits[3];
    private static CardRanks[] reelRank = new CardRanks[3];

    public static void main(String[] args) throws InterruptedException {
        Cards card = Casino.card;
        Casino.ac.setBet(5);
        do {
            dealCards();
            payoutTable();
            spinLeft--;
            System.out.println(text + card.text);
            text = "";
            System.out.println("\nNumber of spins left: " + spinLeft);
            System.out.println("\n" + Casino.ac.userBalance);
        } while (spinLeft > 0 && Casino.ac.validBet());

    }

    private static void payoutTable() {
        if (reelRank[0].worth == 1 && reelRank[1].worth == 1 && reelRank[2].worth == 1) {
            Casino.ac.setMultipler(10);
            spinLeft += 15;
            text += "\nTriple Aces";
        }
        if (isStraight()) {
            Casino.ac.setMultipler(14);
            text += "\nNice Straight";

        }
        if (reelRank[0].equals(reelRank[1]) && reelRank[1].equals(reelRank[2])) {
            Casino.ac.setMultipler(12);
            text += "\nThree of a kind";
        }
        if (reelRank[0].worth > 10 && reelRank[1].worth > 10 && reelRank[2].worth > 10) {
            Casino.ac.setMultipler(10);
            text += "\nAll royals";
        }
        if (reelSuit[0].equals(reelSuit[1]) && reelSuit[1].equals(reelSuit[2])) {
            Casino.ac.setMultipler(5);
            text += "\nThat's a flush";
        } else if (reelSuit[0].getColor().equalsIgnoreCase(reelSuit[1].getColor()) &&
                reelSuit[1].getColor().equalsIgnoreCase(reelSuit[2].getColor())) {
            if (reelSuit[0].getColor().equalsIgnoreCase("red")) {
                text += "\nThat looks all Red";
            } else {
                text += "\nThat looks all Black";
            }
            Casino.ac.setMultipler(2);
        }

        if (Casino.ac.getMultipler() >= 2) {
            Casino.ac.setWinning(true);
        } else {
            Casino.ac.setWinning(false);
        }
        Casino.ac.setCasinoBalance();
        Casino.ac.setMultipler(1);
    }

    private static void dealCards() throws InterruptedException {
        int j = 0;
        Cards card = Casino.card;
        do {
            do {
                reelSuit[j] = card.cardDealtSuit();
                reelRank[j] = card.cardDealtRank();
            }
            while (card.cardIllegalChecker(reelRank[j].ordinal(), reelSuit[j].ordinal()));

            System.out.println("Card " + card.toCardName(reelRank[j], reelSuit[j]));
            j++;
            Thread.sleep(1);
        } while (j < 3);
    }

    private static boolean isStraight() {
        if ((reelRank[0].worth - reelRank[1].worth) == 1 && ((reelRank[1].worth - reelRank[2].worth) == 1)) {
            return true;
        } else if ((reelRank[0].worth - reelRank[1].worth) == -1 && ((reelRank[1].worth - reelRank[2].worth) == -1)) {
            return true;
        } else return false;
    }
}
