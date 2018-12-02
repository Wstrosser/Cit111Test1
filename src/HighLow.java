public class HighLow extends Window {
    public static String text = "";
    public static boolean userGuess = true;
    public static int i;
    public static void HighLow() {
        Account ac = Casino.ac;
        Cards card = Casino.card;
        CardRanks x = CardRanks.Default, xc;
        CardSuits y = CardSuits.Default, yc;
        boolean correct = true;
        int i = 0;

        while (correct) {
            if (x == CardRanks.Default && y == CardSuits.Default) {
                x = card.cardDealtRank();
                y = card.cardDealtSuit();
            }
            i++;
            text = ("Your card is " + card.toCardName(x, y) + ".\nIs the next card higher or lower?");
            do {
                xc = card.cardDealtRank();
                yc = card.cardDealtSuit();
            }
            while (card.cardIllegalChecker(xc.ordinal(), yc.ordinal()));
            text += ("The next card is " + card.toCardName(xc, yc));
            if ((userGuess && x.worth < xc.worth) || (!userGuess && x.worth > xc.worth)) {
                ac.setWinning(true);
            } else {
                ac.setWinning(false);
                correct = false;
                break;
            }
            x = xc;
            y = yc;
        }



    }
}
