public class War extends Window {
    public static String text=null;
    public static void war() throws InterruptedException {
        Account ac = Casino.ac;
        Cards card = Casino.card;
        CardRanks x, xc;
        CardSuits y, yc;


		/*System.out.println("This is the game of war, however, the computer breaks all ties");
		System.out.println("How much would you like to bet?	Your balance is " + ac.userBalance);
		ac.setBet(scanner.nextInt());
		*/


        do {
            y = card.cardDealtSuit();
            x = card.cardDealtRank();
        }
        while (card.cardIllegalChecker(x.ordinal(), y.ordinal()));
        System.out.println("You were dealt " + card.toCardName(x, y));
        text=("You were dealt " + card.toCardName(x, y)+"\n");
        Thread.sleep(100);

        do {

            xc = card.cardDealtRank();
            yc = card.cardDealtSuit();
        }
        while (card.cardIllegalChecker(xc.ordinal(), yc.ordinal()));

        Thread.sleep(100);

        System.out.println("The computer was dealt " + card.toCardName(xc, yc));
        text+=("The computer was dealt " + card.toCardName(xc, yc)+"\n");
        if (x.worth > xc.worth) {
            ac.setWinning(true);
            ac.setCasinoBalance();
        } else {
            ac.setWinning(false);
            ac.setCasinoBalance();
        }
        text+=("\n"+ac.text+"\n"+card.text);
        Thread.sleep(100);

    }
}
