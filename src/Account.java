import javafx.scene.control.Label;

class Account {
    private int balanceCasino = 100000;
    int userBalance = 100;
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
        } else {
            balanceCasino += x;
            userBalance -= x;
            System.out.println("You have lost");
            text = ("You have lost");
        }
    }

    public boolean endGame() {
        if (balanceCasino <= 100) {
            System.out.println("The Casino ran out of money, well done");
            return true;
        } else if (userBalance <= 0) {
            System.out.println("You have ran out of funds");
            text = ("You have ran out of funds");
            return true;
        } else return false;
    }


    public int getPayOut() {
        return betPlace * multipler;
    }

    public void setBet(int x) {
        betPlace = x;
    }

    public boolean validBet() {
        if (betPlace <= 0) {
            text = "Please place a real bet.";
            return false;
        } else if (betPlace > userBalance) {
            text = "You don't have enough funds.";
            return false;
        }
        return (true);
    }
    public void setMultipler(double x){
        this.multipler *= x;
    }
    public void setMultipler(int x) {
        multipler = x;
    }


    public int getMultipler() {
        return this.multipler;
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

    public Label userBalance() {
        return new Label("$ " + this.userBalance + " Current Balance");
    }

    public Label casinoBalance() {
        return new Label("$ " + this.balanceCasino + " Casino's Balance");
    }


}