
public class Casino {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Cards card = new Cards();
		int x,y;
		boolean illegal=false;
		int i = 0;
		while(i<15) {
		y=card.cardDealtType();
		x=card.cardDealtValue();
			while(card.cardIllegalChecker(x, y)==true) {
				x=card.cardDealtValue();
				y=card.cardDealtType();
			}
			Thread.sleep(100);
			System.out.println(card.cardName(x,y)+"  "+ x +" "+y);
	i++;}Account ac = new Account();
		System.out.println((ac.balanceCasino-=956));
		System.out.println(ac.balanceCasino);
	}
}
