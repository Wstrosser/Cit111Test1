
public class Casino {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Cards card = new Cards();
		boolean illegal=false;
		int x,y;
		while(illegal==false) {
		y=card.cardDealtType();
		x=card.cardDealtValue();
			System.out.println(card.cardName(card.cardDealtValue(), card.cardDealtType()));
			Thread.sleep(10);
			illegal = card.cardIllegalChecker(x, y);
	}
	}
}
