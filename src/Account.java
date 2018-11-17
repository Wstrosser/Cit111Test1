
public class Account {
	int balanceCasino = 1000, userBalance = 100;
	int betPlace, multipler=1, betPayout;
	boolean isWinning=false;
	public int getCasinoBalance() {
		return this.balanceCasino;
	}

	public void setCasinoBalance() {
		int x = getPayOut();
		if (!isWinning) {
			balanceCasino -= x;
			userBalance +=x;
		}

		else {
			balanceCasino += x;
			userBalance -=x;
		}
	}
	public boolean endGame() {
		if(balanceCasino<=100||userBalance==0) {System.out.println("End of Game"); return true;}
		else return false;
	}
	public int getPayOut() {
		betPayout=betPlace*multipler;
		return betPayout;
	}
	void setBet(int x) {
		if (userBalance>=betPlace)betPlace = x;
		else System.out.println("Can't place a bet that high!"); }
	void setMultipler(int x) {
		multipler = x;
	}
	public int getUserBalance() {
		return userBalance;
	}
	public void setWinning(boolean x) {
		if(x==true) isWinning=true;
		else isWinning=false;
	}
	public void endOfHand(boolean x, int a, int b) {
		setWinning(x);
		setBet(a);
		setMultipler(b);
		setCasinoBalance();
	}
}