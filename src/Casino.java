
public class Casino {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Cards card = new Cards();
		int x,y;
		boolean illegal=false;
		while(illegal==false) {
		y=card.cardDealtType();
		x=card.cardDealtValue();
			System.out.println(card.cardName(x,y));
			Thread.sleep(10);
			illegal = card.cardIllegalChecker(x, y);
	}
	}
}
