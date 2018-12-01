
public enum CardRanks{
	ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12),
	KING(13);
	final int worth;

	public int getValue() {
		return worth;
	}
	public int getValueBJ() {
		int worth;
		int x = this.worth;
		if (x == 1)
			worth = 11;
		else if (x >= 10) {
			worth = 10;
		} else
			worth = x;
		return worth;
	}

	CardRanks(int value) {
		this.worth = value;
	}


}
