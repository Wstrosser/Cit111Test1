import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;




class CardImages {

    public void drawCard(Graphics g, CardRanks rank, CardSuits card, int x, int y) {
        int cx;    // x-coord of upper left corner of the card inside cardsImage
        int cy;    // y-coord of upper left corner of the card inside cardsImage
        if (card == null) {
            cy = 492;   // coords for a face-down card.
            cx = 158;
        }
        else {
            cx = (rank.worth-1)*158;
            switch (card) {
                case Hearts:
                    cy = 0;
                    break;
                case Clubs:
                    cy = 200;
                    break;
                case Diamonds:
                    cy = 400;
                    break;
                default:
                    cy = 600;
                    break;
            }
        }
        g.drawImage(img,x,y,x+185,y+200,cx,cy,cx+185,cy+200, (ImageObserver) this);
    }
    private static BufferedImage img = null;
    static void main (String [] args) {
        try {
          img = ImageIO.read(new File("resources/CardFrontScaled.png"));
        } catch (IOException ignored) {
        }



    }



    }

