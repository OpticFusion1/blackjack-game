/**
* This is the class for players in blackjack.
* @author Crishna Iyengar
* @version 1.0
*/

public class Player {

    private int playerScore;
    private int[] playerCards = new int[7];
    private int cardCount;

    /**
    * This constructor makes a player object.
    * Two instance variables: player score and their hand
    */

    public Player() {
        this.playerScore = playerScore;
        this.playerCards = playerCards;
    }

    /**
    * This method takes in a cardval and adds it to the score.
    * @param cardVal the value of a drawn card
    */

    public void setPlayerScore(int cardVal) {
        this.playerScore = this.playerScore + cardVal;
        this.playerCards[cardCount] = cardVal;
        cardCount++;
    }

    /**
    * This method returns the player's score.
    * @return the player's score
    */

    public int getPlayerScore() {
        return this.playerScore;
    }

    /**
    * This method returns the player's Cards
    * @return playerCards
    */

    public int[] getPlayerCards() {
        return this.playerCards;
    }
}