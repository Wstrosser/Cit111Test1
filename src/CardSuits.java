
public enum CardSuits {
	Hearts("Red"), Spades("Black"), Diamonds("Red"), Clubs("Black"), Default("White");
	private final String color;

	public String getColor() {
		return this.color;
	}

	CardSuits(String color) {
		this.color = color;
	}

}
