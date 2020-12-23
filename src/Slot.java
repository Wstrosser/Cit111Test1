
/*  Ace Free spin 15
    3 of a kind 5
    Royals 4
    Straight 3
    Suit 2
    Color 1
 */
class Slot {
    public static String[] cards = new String[3];
    public static String text;
    public static String payoutText;
    private static int spinLeft = 0;
    public static CardSuits[] reelSuit = new CardSuits[3];
    public static CardRanks[] reelRank = new CardRanks[3];

    public static void slot() throws InterruptedException {
        Cards card = Casino.card;
        do {
            dealCards();
            payoutTable();
            text = "";
            System.out.println(text + card.text);
            System.out.print("\nNumber of spins left: " + spinLeft);
            System.out.println("\n" + Casino.ac.userBalance);
        } while (spinLeft > 0 && Casino.ac.validBet());
        Casino.ac.setCasinoBalance();
    }

    private static void payoutTable() {
        if (reelRank[0].worth == 1 && reelRank[1].worth == 1 && reelRank[2].worth == 1) {
            //Casino.ac.setMultipler(10);

            payoutText += "\nTriple Aces";spinLeft += 15;
        }
        if (isStraight()) {
            Casino.ac.setMultipler(5.0);
            payoutText += "\nNice Straight";

        }
        if (reelRank[0].equals(reelRank[1]) && reelRank[1].equals(reelRank[2])) {
            Casino.ac.setMultipler(7.0);
            payoutText += "\nThree of a kind";
        } else if(reelRank[0].equals(reelRank[1])||reelRank[1].equals(reelRank[2])||reelRank[0].equals(reelRank[2])){
            Casino.ac.setMultipler(2.0);
            payoutText += "\nNice pair";
        }
        if (reelRank[0].worth > 10 && reelRank[1].worth > 10 && reelRank[2].worth > 10) {
            Casino.ac.setMultipler(4.0);
            payoutText += "\nAll royals";
        }
        if (reelSuit[0].equals(reelSuit[1]) && reelSuit[1].equals(reelSuit[2])) {
            Casino.ac.setMultipler(4.0);
            payoutText += "\nThat's a flush";
        } /*else if (reelSuit[0].getColor().equalsIgnoreCase(reelSuit[1].getColor()) &&
                reelSuit[1].getColor().equalsIgnoreCase(reelSuit[2].getColor())) {
            if (reelSuit[0].getColor().equalsIgnoreCase("red")) {
                text += "\nThat looks all Red";
            } else {
                text += "\nThat looks all Black";
            }
            Casino.ac.setMultipler(2);
        }*/

        if (Casino.ac.getMultipler() >= 2) {
            Casino.ac.setWinning(true);
            Casino.ac.setCasinoBalance();
            Casino.ac.setMultipler(1);
        } else {
            Casino.ac.setWinning(false);
        }


    }

    private static void dealCards() throws InterruptedException {
        int j = 0;
        Cards card = Casino.card;
        do {
            do {
                reelSuit[j] = card.cardDealtSuit();
                reelRank[j] = card.cardDealtRank();
                cards[j]=card.toCardName(reelRank[j],reelSuit[j]);
            }
            while (card.cardIllegalChecker(reelRank[j].ordinal(), reelSuit[j].ordinal()));

            System.out.println("Card " + card.toCardName(reelRank[j], reelSuit[j]));
            j++;
            Thread.sleep(0);
        } while (j < 3);
    }

    private static boolean isStraight() {
        if ((reelRank[0].worth - reelRank[1].worth) == 1 && ((reelRank[1].worth - reelRank[2].worth) == 1)) {
            return true;
        } else return (reelRank[0].worth - reelRank[1].worth) == -1 && ((reelRank[1].worth - reelRank[2].worth) == -1);
    }
}
