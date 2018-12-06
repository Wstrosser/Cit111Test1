class HighLow {
    public static String text = "  ";
    public static String userGuess;
    private static int i = 1;
    private static CardRanks x = CardRanks.Default;
    private static CardSuits y = CardSuits.Default;
    private static final Cards card = Casino.card;
    public static boolean started= false;
    public static void startHighLower() {
        if (i==1) {
            resetGame();
            x = card.cardDealtRank();
            y = card.cardDealtSuit();
            card.cardIllegalChecker(x.ordinal(), y.ordinal());
            started = true;
        }
        text += ("\nYour card is " + card.toCardName(x, y) + ".\nIs the next card higher or lower?");
    }

    public static void HighLow() {
        Account ac = Casino.ac;


        CardSuits yc;
        CardRanks xc;
        do {
            xc = card.cardDealtRank();
            yc = card.cardDealtSuit();
        }
        while (card.cardIllegalChecker(xc.ordinal(), yc.ordinal()));
        text = ("\nThe next card is " + card.toCardName(xc, yc));
        if ((userGuess.equalsIgnoreCase("Higher") &&
                x.worth < xc.worth)
                || (userGuess.equalsIgnoreCase("Lower") &&
                x.worth > xc.worth)) {
            text += ("\nYou are right.");
            HighLow.i++;
        } else {
            ac.setMultipler((HighLow.i) / 4);
            if(ac.getMultipler()<1){ac.setMultipler(1);ac.setWinning(false);text+="\nYou lost $"+ac.getPayOut();}
            else {ac.setWinning(true); text+="\nYou have won $"+ac.getPayOut();}

            text += ("\nYou got one wrong, you got " + HighLow.i + " cards right in a row.");
            ac.setCasinoBalance();
            i = 1;

        }
        x = xc;
        y = yc;

        System.out.println(text + "\t" + HighLow.i);

    }
    private static void resetGame(){
        x=CardRanks.Default;
        y=CardSuits.Default;
        Casino.ac.betPlace=0;
    }
}

