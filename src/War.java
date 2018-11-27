import java.util.*;

public class War {
	public static void war() throws InterruptedException {
		String buffer = null;
		Account ac = Casino.ac;
		Cards card = new Cards();
		Scanner scanner = new Scanner(System.in);
		char next = 'y';
		CardRanks x, xc;
		CardSuits y, yc;
		boolean win = false;

		System.out.println("This is the game of war, however, the computer breaks all ties");
		System.out.println("How much would you like to bet?	Your balance is " + ac.userBalance);
		ac.setBet(scanner.nextInt());
		
		while (next == 'y'  && ac.validBet() && !ac.endGame()) {

			y = card.cardDealtSuit();
			x = card.cardDealtRank();

			while (card.cardIllegalChecker(x.ordinal(), y.ordinal()) == true) {
				x = card.cardDealtRank();
				y = card.cardDealtSuit();
			}
			Thread.sleep(100);
			yc = card.cardDealtSuit();
			xc = card.cardDealtRank();

			while (card.cardIllegalChecker(xc.ordinal(), yc.ordinal()) == true) {
				xc = card.cardDealtRank();
				yc = card.cardDealtSuit();
			}
			Thread.sleep(100);
			System.out.println("You were dealt " + card.cardName(x, y));
			System.out.println("The computer was dealt " + card.cardName(xc, yc));

			if (x.worth > xc.worth) {
				win = true;
				//System.out.println(x.worth + "   " + xc.worth);
				ac.setWinning(win);
				ac.setCasinoBalance();
			} else
				ac.setCasinoBalance();

			Thread.sleep(100);
			System.out.println("Would you like to play again? Your balance is " + ac.userBalance);
			
			try {scanner.hasNext(); buffer.equals(scanner.nextLine().toLowerCase());
				next = buffer.charAt(0) ; System.out.println(next);
			} catch (Exception e) {
				System.out.println("Anything");
			}
		}
		scanner.close();
		if(next == 'n') System.out.println("Thank you for playing");
		else if (!ac.validBet()) System.out.println("Next time please place a valid bet");
		else if (ac.endGame()) System.out.println("");
		else System.out.println("An error has happened");
	}
}
