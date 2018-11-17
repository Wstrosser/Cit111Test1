import java.util.*;

public class War {
	public static void main(String [] args) throws InterruptedException {
		System.out.println("This is the game of war, however, the computer breaks all ties");
		Account ac = Casino.ac;
		Cards card = new Cards();
		Scanner scanner = new Scanner(System.in);
		char next = 'y';
		String scanner1 = "y";
		CardRanks x, xc;
		CardSuits y, yc;
		
			


			while(next=='y'&&!ac.endGame()) {
				boolean win=false;
					System.out.println("How much would you like to bet?	Your balance is "+ac.userBalance);
					ac.setBet(scanner.nextInt());
				y = card.cardDealtSuit();
				x = card.cardDealtRank();
				while (card.cardIllegalChecker(x.ordinal(), y.ordinal()) == true) {
					x = card.cardDealtRank();
					y = card.cardDealtSuit();
				}
				yc = card.cardDealtSuit();
				xc = card.cardDealtRank();
				while (card.cardIllegalChecker(xc.ordinal(), yc.ordinal()) == true) {
					xc = card.cardDealtRank();
					yc = card.cardDealtSuit();
				}
				System.out.println("You were dealt "+ card.cardName(x, y));
				System.out.println("The computer was dealt "+ card.cardName(xc, yc));
				if(x.worth>xc.worth) {win=true;
					System.out.println(x.worth+"   " + xc.worth);
					ac.setWinning(win);
					ac.setCasinoBalance();
				}
				else ac.setCasinoBalance();
				
				System.out.println("Would you like to play again? Your balance is " + ac.userBalance);
				Thread.sleep(100);
				
				scanner1 = scanner.next();
				scanner1 = scanner1.toLowerCase();
				next= scanner1.charAt(0);
				}

	}}
