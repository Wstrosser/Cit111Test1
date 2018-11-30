public class Casino {
static Account ac = new Account();
static War war = new War();
static Cards card = new Cards();
static CardRanks playerRank, computerRank;
static CardSuits playerSuit, computerSuit;
static int i =0;
public static void main(String[] args) throws InterruptedException {
//		// TODO Auto-generated method stub
//		Cards card = new Cards();
//		CardRanks x;
//		CardSuits y;
//		int i = 0;
//		while (i < 150&&!ac.endGame()) {
//			y = card.cardDealtSuit();
//			x = card.cardDealtRank();
//			while (card.cardIllegalChecker(x.ordinal(), y.ordinal()) == true) {
//				x = card.cardDealtRank();
//				y = card.cardDealtSuit();
//			}
//			Thread.sleep(100);
//			System.out.println(card.cardName(x, y) + "  " + x.worth + " " + y.ordinal()+" "
//					+ i);
//			i++;System.out.println((ac.balanceCasino -= x.worth*(y.ordinal()+1)*1.5));
//			System.out.println(x);
//			
//			}
//			
//		}
	
	War.war();
}}

