import java.util.Random;

class Cards {
    private final boolean[][] array = new boolean[13][4];
    private final Random random = new Random();
    private final CardRanks[] CardRank = CardRanks.values();
    private final CardSuits[] cardSuit = CardSuits.values();
    private int i;
    public String text;


    /**
     * Gets card's full name
     * This method use for user friendly card name.
     *
     * @param x Card's rank
     * @param y Card's Suit
     * @return String of the card's full name
     */
    public String toCardName(CardRanks x, CardSuits y) {
        String name;
        switch (x) {
            case ACE:
                name = "Ace ";
                break;
            case TWO:
                name = "Two ";
                break;
            case THREE:
                name = "Three ";
                break;
            case FOUR:
                name = "Four ";
                break;
            case FIVE:
                name = "Five ";
                break;
            case SIX:
                name = "Six ";
                break;
            case SEVEN:
                name = "Seven ";
                break;
            case EIGHT:
                name = "Eight ";
                break;
            case NINE:
                name = "Nine ";
                break;
            case TEN:
                name = "Ten ";
                break;
            case JACK:
                name = "Jack ";
                break;
            case QUEEN:
                name = "Queen ";
                break;
            case KING:
                name = "King ";
                break;
                default: name = "Default ";

        }

        return name+ ("of " + y);
    }

    public CardRanks cardDealtRank() {
        int type = random.nextInt(13);
        return CardRank[type];
    }

    public CardSuits cardDealtSuit() {
        int suit = random.nextInt(4);
        return cardSuit[suit];
    }

    @SuppressWarnings("WeakerAccess")
    public void resetChecker() {
        for (int i = 0; i < 0b1101; i++) {
            for (int j = 0; j < 0b100; j++) {
                array[i][j] = false;
            }
        }
        this.text+=("\n"+"The deck has been shuffled");
        i=0;
    }

    public boolean cardIllegalChecker(int x, int y) {

        if (array[x][y]) {
            return true;
        } else {i++;
            this.text=("Cards played: "+i);
            array[x][y] = true;
        }
        if(i>= 52){resetChecker();System.out.println("Shuffle");
           }
        return false;
    }

}


