
class Account {
	int balanceCasino = 100000, userBalance = 100;
	int betPlace;
	private int multipler = 1;
	private boolean isWinning = false;
	public String text;
	public int getCasinoBalance() {
		return this.balanceCasino;
	}

	public void setCasinoBalance() {
		int x = getPayOut();
		if (isWinning) {
			balanceCasino -= x;
			userBalance += x;
			System.out.println("You have won");
			text = ("You have won");
		}

		else {
			balanceCasino += x;
			userBalance -= x;
			System.out.println("You have lost");
			text=("You have lost");
		}
	}

	public boolean endGame() {
		if (balanceCasino <= 100)
		{System.out.println("The Casino ran out of money, well done");
			return true;}
		
		else if(userBalance<=0) {System.out.println("You have ran out of funds");
		text = ("You have ran out of funds");
		return true;}
		else	return false;}
	

	private int getPayOut() {
		return betPlace * multipler;
	}

	private void setBet(int x) {
			betPlace = x;
	}
	public boolean validBet() {
		return betPlace <= userBalance;
	}

	private void setMultipler(int x) {
		multipler = x;
	}

	public int getUserBalance() {
		return userBalance;
	}

	public void setWinning(boolean x) {
		isWinning = x;
	}

	public void endOfHand(boolean x, int a, int b) {
		setWinning(x);
		setBet(a);
		setMultipler(b);
		setCasinoBalance();
	}
}