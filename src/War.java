import java.util.Scanner;

public class War extends Window {

    public static void war() throws InterruptedException {
        Account ac = Casino.ac;
        Cards card = Casino.card;
        Scanner scanner = new Scanner(System.in);
        char next = 'y';
        CardRanks x = Casino.playerRank, xc = Casino.computerRank;
        CardSuits y = Casino.playerSuit, yc = Casino.computerSuit;
        int i = Casino.i;

		/*System.out.println("This is the game of war, however, the computer breaks all ties");
		System.out.println("How much would you like to bet?	Your balance is " + ac.userBalance);
		ac.setBet(scanner.nextInt());
		*/

        if (i >= 52) {
            card.resetChecker();
            System.out.println("The deck is shuffled");
        }
        do {
            i++;
            y = card.cardDealtSuit();
            x = card.cardDealtRank();
        }
        while (card.cardIllegalChecker(x.ordinal(), y.ordinal()));


        Thread.sleep(100);

        do {
            i++;
            xc = card.cardDealtRank();
            yc = card.cardDealtSuit();
        }
        while (card.cardIllegalChecker(xc.ordinal(), yc.ordinal()));

        Thread.sleep(100);
        System.out.println("You were dealt " + card.toCardName(x, y));
        System.out.println("The computer was dealt " + card.toCardName(xc, yc));
        System.out.println(i + " Cards have been played");

        if (x.worth > xc.worth) {
            //System.out.println(x.worth + "   " + xc.worth);
            ac.setWinning(true);
            ac.setCasinoBalance();
        } else {
            ac.setWinning(false);
            ac.setCasinoBalance();
        }
        Thread.sleep(100);

    }
}
