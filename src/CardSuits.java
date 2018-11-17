
public enum CardSuits {
	Heart("Red"), Spade("Black"), Diamond("Red"), Club("Black");
	String color;

	public String getColor() {
		return this.color;
	}

	private CardSuits(String color) {
		this.color = color;
	}

}
