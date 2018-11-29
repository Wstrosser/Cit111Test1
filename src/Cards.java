import java.util.*;

public class Cards {
	public boolean[][] array = new boolean[14][5];
	Random random=new Random();
	CardRanks[] CardRank = CardRanks.values();
	CardSuits[] cardSuit= CardSuits.values();
	public int cardWorthBlackJack(int x) {
		int worth;
		if (x == 1)
			worth = 11;
		else if (x >= 10) {
			worth = 10;
		} else
			worth = x;
		return worth;
	}

	/**
	 * Gets card's full name
	 * This method use for user friendly card name.
	 * @param x Card's rank
	 * @param y Card's Suit
	 * @return String of the card's full name
	 */
	public String toCardName(CardRanks x, CardSuits y) {
		String name = null;
		switch (x) {
		case ACE:
			name = "Ace ";
			break;
		case TWO:
			name = "Two ";
			break;
		case THREE:
			name = "Three ";
			break;
		case FOUR:
			name = "Four ";
			break;
		case FIVE:
			name = "Five ";
			break;
		case SIX:
			name = "Six ";
			break;
		case SEVEN:
			name = "Seven ";
			break;
		case EIGHT:
			name = "Eight ";
			break;
		case NINE:
			name = "Nine ";
			break;
		case TEN:
			name = "Ten ";
			break;
		case JACK:
			name = "Jack ";
			break;
		case QUEEN:
			name = "Queen ";
			break;
		case KING:
			name = "King ";
			break;
		
		}
		name+="of "+y;
		return name;
	}
	public CardRanks cardDealtRank() {
		int type = random.nextInt(13);
		return CardRank[type];
	}
	public CardSuits cardDealtSuit() {
		int suit = random.nextInt(4);
		return cardSuit[suit];
	}
	public boolean cardIllegalChecker(int x, int y)
	{boolean invalid=false;
		if(array[x][y]) {
			invalid = true;
		}else {array[x][y]=true;}
		
		return invalid;
	}
	public void resetChecker() {
		for(int i=0; i<14; i++) {
			for(int j=0; j<4; j++) {
				array[i][j]=false;
			}
		}
	}
}

