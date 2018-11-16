package Testing;

public class test1 {
public static void main(String [] args) {
	Hand hand = new Hand();
	Deck deck = new Deck(false);
	Card card = new Card();
	deck.shuffle();
	
	for(int i = 0; i <35; i++) {
		System.out.println();
	}
}
}
 