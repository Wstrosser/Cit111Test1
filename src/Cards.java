import java.util.*;
public class Cards {
	public boolean[][] array = new boolean[14][5];
	public int cardWorthBlackJack(int x) {
		int worth;
		if (x == 1)
			worth = 11;
		else if (x >= 10) {
			worth = 10;
		} else
			worth = x;
		return worth;
	}

	public String cardName(int x, int y) {
		String name = null;
		switch (x) {
		case 1:
			name = "Ace ";
			break;
		case 2:
			name = "Two ";
			break;
		case 3:
			name = "Three ";
			break;
		case 4:
			name = "Four ";
			break;
		case 5:
			name = "Five ";
			break;
		case 6:
			name = "Six ";
			break;
		case 7:
			name = "Seven ";
			break;
		case 8:
			name = "Eight ";
			break;
		case 9:
			name = "Nine ";
			break;
		case 10:
			name = "Ten ";
			break;
		case 11:
			name = "Jack ";
			break;
		case 12:
			name = "Queen ";
			break;
		case 13:
			name = "King ";
			break;
		}
		switch (y) {
		case 1:
			name += "of Hearts";
			break;
		case 2:
			name += "of Spades";
			break;
		case 3:
			name += "of Diamonds";
			break;
		case 4:
			name += "of Clubs";
			break;
		}

		return name;
	}
	public int cardDealtValue() {
		Random random=new Random();
		int type = random.nextInt(13);
		type++;
		return type;
	}
	public int cardDealtType() {
		Random random = new Random();
		int value = random.nextInt(3);
		value++;
		return value;
	}
	public boolean cardIllegalChecker(int x, int y)
	{boolean valid=false;
		if(array[x][y]==false) {
			array[x][y]=true;
		}else {valid=true;}
		
		return valid;
	}
}
