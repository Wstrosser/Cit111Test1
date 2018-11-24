
public class Account {
	int balanceCasino = 1000, userBalance = 100;
	int betPlace, multipler = 1, betPayout;
	boolean isWinning = false;

	public int getCasinoBalance() {
		return this.balanceCasino;
	}

	public void setCasinoBalance() {
		int x = getPayOut();
		if (isWinning) {
			balanceCasino -= x;
			userBalance += x;
			System.out.println("You have won");
		}

		else {
			balanceCasino += x;
			userBalance -= x;
			System.out.println("You have lost");
		}
	}

	public boolean endGame() {
		if (balanceCasino <= 100)
		{System.out.println("The Casino ran out of money well done");
			return true;}
		
		else if(userBalance<=0) {System.out.println("You have ran out of funds"); return true;}
		else	return false;}
	

	public int getPayOut() {
		betPayout = betPlace * multipler;
		return betPayout;
	}

	void setBet(int x) {
			betPlace = x;
	}
	public boolean validBet() {
		if (betPlace<=userBalance)return true;
		else return false;
	}

	public void setMultipler(int x) {
		multipler = x;
	}

	public int getUserBalance() {
		return userBalance;
	}

	public void setWinning(boolean x) {
		if (x == true)
			isWinning = true;
		else
			isWinning = false;
	}

	public void endOfHand(boolean x, int a, int b) {
		setWinning(x);
		setBet(a);
		setMultipler(b);
		setCasinoBalance();
	}
}