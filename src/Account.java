
public class Account {
	int balanceCasino = 100000, userBalance = 100;
	int betPlace, multipler;
	boolean isWinning;
	int betPayout ;
	public int getCasinoBalance() {
		return this.balanceCasino;
	}

	public void setCasinoBalance(int x) {
		x = payOut();
		if (isWinning) {
			balanceCasino -= x;
			userBalance +=x;
		}

		else {
			balanceCasino += x;
			userBalance -=x;
		}
	}
	public boolean endGame() {
		if(balanceCasino<=100) return true;
		else return false;
	}
	private int payOut() {
		betPayout=betPlace*multipler;
		return betPayout;
	}
	void setBet(int x) {
		betPlace = x;
	}
	void setMultipler(int x) {
		multipler = x;
	}
	public int getPayout() {
		return betPayout;
	}
	public int getUserBalance() {
		return userBalance;
	}
}