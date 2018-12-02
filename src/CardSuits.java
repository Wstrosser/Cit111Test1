
public enum CardSuits {
	Heart("Red"), Spade("Black"), Diamond("Red"), Club("Black"), Default("White");
	private String color;

	public String getColor() {
		return this.color;
	}

	CardSuits(String color) {
		this.color = color;
	}

}
