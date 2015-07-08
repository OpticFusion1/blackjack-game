import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;

/**
* This class represents a Card object for Blackjack.
* @author Crishna Iyengar
* @version 1.0
*/

public class Cards {

    private static int[] dealtCards = new int[14];
    private int cardValue;
    private boolean faceUp;
    private Random randy = new Random();
    private static int cardCount = 0;
    private Scanner scan = new Scanner(System.in);
    private String name;

    /**
    *This is a constructor for a Card. Takes in
    *faceup boolean and a name.
    * @param faceUp if the card is flipped or not
    * @param name Name of the Player
    */

    public Cards(boolean faceUp, String name) {
        int newCard = randy.nextInt(52) + 1;
        Arrays.sort(dealtCards);
        while (Arrays.binarySearch(dealtCards, newCard) > 0) {
            newCard = randy.nextInt(52) + 1;
        }
        dealtCards[cardCount] = newCard;
        cardCount++;
        this.cardValue = newCard;
        this.faceUp = faceUp;
        this.name = name;
        if (faceUp) {
            System.out.println(name + " was dealt a  "
                + this.getCardName() + " of " + this.getSuit() + "!");
        } else {
            System.out.println(name + " was dealt a face down card.");
        }
    }

    /**
    * return the value of a card.
    * @return a card value 1-10 or a jack, queen, king, or ace.
    */

    public int getCardValue() {
        if (this.cardValue % 13 > 1 && this.cardValue % 13 < 11) {
            return this.cardValue % 13;
        } else if (this.cardValue % 13 == 1) {
            System.out.println("How would you like to "
                + "count the Ace? Enter 1 or 11.");
            int aceVal = scan.nextInt();
            return aceVal;
        } else {
            return 10;
        }
    }

    /**
    * For a certain Cards object, returns boolean if it is faceup.
    * @return boolean true if the card object is flipped up.
    */

    public boolean getFaceUp() {
        return this.faceUp;
    }

    /**
    * Changes the card's faceup instance variable.
    *@param faceUp takes in a boolean to change the faceup value.
    */
    public void setFaceUp(boolean faceUp) {
        this.faceUp = faceUp;
        System.out.println("The card has been flipped! The dealer's card is a "
            + this.getCardName() + " of " + this.getSuit() + ".");
    }

    /**
    * this method takes in a Player, which is a dealer, and calculates
    * the score for his cards.
    * @param dealer a Player
    * @return the value of the card in blackjack.
    */

    public int getCardValueDealer(Player dealer) {
        if (this.cardValue % 13 > 1 && this.cardValue % 13 < 11) {
            return this.cardValue % 13;
        } else if (this.cardValue % 13 == 1) {
            int randoNum = randy.nextInt(1);
            if (dealer.getPlayerScore() < 11) {
                System.out.println("The dealer chooses to "
                    + "count the Ace as an 11.");
                return 11;
            } else {
                System.out.println("The dealer chooses to "
                    + " count the Ace as a 1.");
                return 1;
            }
        } else {
            return 10;
        }
    }

    /**
    * This method returns the cardValue of the object.
    * @return the cardValue of the Cards object.
    */


    public int getCardNum() {
        return this.cardValue;
    }

    /**
    * This method gets the card name 2-10
    * or royalty Strings.
    * @return String of the random card
    */

    public String getCardName() {
        if (this.cardValue % 13 > 1 && this.cardValue % 13 < 11) {
            return Integer.toString(this.cardValue % 13);
        } else if (this.cardValue % 13 == 1) {
            return "Ace";
        } else if (this.cardValue % 13 == 11) {
            return "Jack";
        } else if (this.cardValue % 13 == 12) {
            return "Queen";
        } else {
            return "King";
        }

    }

    /**
    * This static method sets the static variable dealtCards to
    * an array of zeros for a new round.
    */

    public static void setDealtCards() {
        for (int i = 0; i < 14; i++) {
            dealtCards[i] = 0;
        }
    }

    /**
    * This static method sets the cardCount to zero
    * for each new game.
    */

    public static void setCardCount() {
        cardCount = 0;
    }

    /**
    * This method gets the suit of a card object.
    * @return String of suit name
    */

    public String getSuit() {
        if (this.cardValue < 14) {
            return "Spades";
        } else if (this.cardValue < 27) {
            return "Cloves";
        } else if (this.cardValue < 40) {
            return "Hearts";
        } else {
            return "Diamonds";
        }
    }
}
