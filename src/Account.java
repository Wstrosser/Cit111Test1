
public class Account {
	int balanceCasino = 100000, userBalance = 100;
	int betPlace, betPayout;
	boolean isWinning;

	public int getCasinoBalance() {
		return this.balanceCasino;
	}
	public void setCasinoBalance(int x) {
		balanceCasino=x;
	}
	
}