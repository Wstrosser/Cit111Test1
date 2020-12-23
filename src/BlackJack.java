/*
import java.util.Scanner;


class BlackJack {
    public static String text = null;
    Account ac = Casino.ac;
    Cards card = Casino.card;
    private static CardRanks x[], xc[];
    private static CardSuits y[], yc[];

    public void blackjack() throws InterruptedException {
        startGame();
        Scanner input = new Scanner(System.in);
        System.out.println(" Hand value: " + getHandValue(x));
        System.out.println("Hit?");

        if (input.nextLine().equalsIgnoreCase("hit")) {

            addCard(x,y);
            if (getHandValue(x) > 21) {
                System.out.println("Bust");
                System.out.println("You lost!");
                break;
            }
            continue;
        } else if (getHandValue(player) >= getHandValue(dealer)) {
            System.out.println("You won!");
            break;
        } else {
            System.out.println("you lost");
            break;
        }

        System.out.println("Dealer : \n" + dealer.toString() + "Hand value: " + getHandValue(dealer));
        System.out.println("You: \n" + player.toString() + "Hand value: " + getHandValue(dealer));

        dealer.Fold(d);
        player.Fold(d);

        System.out.println("Do you want to play again?");
        if (input.nextLine().equalsIgnoreCase("No")) {
            System.out.println("Good game.");
            System.exit(0);
        }
    }



    public static int getHandValue(CardRanks x[]) {
        int total=0;
        for(int i =0; x[i]!=null; i++){
            total += x[i].getValueBJ();
        }

        return total;
    }

    int getHandSize(CardRanks x[]){
        int i=0;
        while(x[i]!=null){i++;}
        return i;
    }

    private static void resetGame() {
        for (int i = 0; i <= 5; i++) {
            x[i] = CardRanks.Default;
            y[i] = CardSuits.Default;
            Casino.ac.betPlace = 0;
        }
        for (int i = 0; i <= 5; i++) {
            xc[i] = CardRanks.Default;
            yc[i] = CardSuits.Default;
        }
    }

    private void startGame() {
    resetGame();
    int i = 0;
        do {
            y[i] = card.cardDealtSuit();
            x[i] = card.cardDealtRank();
            i++;
        }
        while (card.cardIllegalChecker(x[i].ordinal(), y[i].ordinal()) && i < 2);
        do {
            yc[i] = card.cardDealtSuit();
            xc[i] = card.cardDealtRank();
            i++;
        }
        while (card.cardIllegalChecker(xc[i].ordinal(), yc[i].ordinal()) && i < 2);
    }

    public void addCard(CardRanks x[], CardSuits[] y){
        int j;
        for(j = 0; x[j]==null; j++)
        do {
            y[j] = card.cardDealtSuit();
            x[j] = card.cardDealtRank();
        }
        while(card.cardIllegalChecker(x[j].ordinal(), y[j].ordinal()));

    }


}*/