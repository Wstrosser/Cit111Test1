public class Casino {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Cards card = new Cards();
		CardRanks x;
		CardSuits y;Account ac = new Account();
		int i = 0;
		while (i < 150&&!ac.endGame()) {
			y = card.cardDealtSuit();
			x = card.cardDealtRank();
			while (card.cardIllegalChecker(x.ordinal(), y.ordinal()) == true) {
				x = card.cardDealtRank();
				y = card.cardDealtSuit();
			}
			Thread.sleep(100);
			System.out.println(card.cardName(x, y) + "  " + x.worth + " " + y.ordinal()+" "
					+ i);
			i++;System.out.println((ac.balanceCasino -= x.worth*(y.ordinal()+1)*1.5));
			System.out.println(x);
			
			}
			
		}
	}

