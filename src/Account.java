
public class Account {
	int balanceCasino = 100000, userBalance = 100;
	int betPlace, betPayout;
	boolean isWinning;

	public int getCasinoBalance() {
		return this.balanceCasino;
	}
	public void setPlusCasinoBalance(int x) {
		balanceCasino+=x;
	}
	public void setMinusCasinoBalance(int x) {
		balanceCasino-=x;
	}
	
}