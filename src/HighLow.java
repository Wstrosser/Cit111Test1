class HighLow {
    public static String text = "  ";
    public static String userGuess;
    private static int i = 1;
    private static CardRanks x = CardRanks.Default;
    private static CardRanks xc;
    private static CardSuits y = CardSuits.Default;
    private static CardSuits yc;
    private static Cards card = Casino.card;

    public static void startHighLower() {
        if (x == CardRanks.Default && y == CardSuits.Default) {
            x = card.cardDealtRank();
            y = card.cardDealtSuit();
            card.cardIllegalChecker(x.ordinal(), y.ordinal());
        }
        text = ("\nYour card is " + card.toCardName(x, y) + ".\nIs the next card higher or lower?");
    }

    public static void HighLow() {
        Account ac = Casino.ac;


        do {
            xc = card.cardDealtRank();
            yc = card.cardDealtSuit();
        }
        while (card.cardIllegalChecker(xc.ordinal(), yc.ordinal()));
        text += ("\nThe next card is " + card.toCardName(xc, yc));
        if ((userGuess.equalsIgnoreCase("Higher") && x.worth < xc.worth) || (userGuess.equalsIgnoreCase("Lower") && x.worth > xc.worth)) {
            text += ("\nYou are right.");
            HighLow.i++;
        } else {
            ac.setMultipler((HighLow.i) / 3);
            text += ("\nYou are wrong, you got " + HighLow.i + " cards right in a row.\nYour multiplier is " + ac.getMultipler());
            ac.setWinning(true);
            ac.setCasinoBalance();
            i = 0;
        }
        x = xc;
        y = yc;

        System.out.println(text + "\t" + HighLow.i);

    }
}

