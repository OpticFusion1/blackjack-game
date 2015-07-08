import java.util.Scanner;

/**
* This class is the driver for the blackjack game.
* @author Crishna Iyengar
* @version 1.0
*/
public class Driver {

    /**
    * This method is the main method. Executes all the code.
    * @param args
    */

    public static void main(String[] args) {

        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Welcome to Blackjack! What is your name?");
            String playerName = scan.nextLine();
            boolean willPlay = true;
            Player player = new Player();
            Player dealer = new Player();
            Driver swag = new Driver();
            System.out.println("Goal is to get as close to 21 "
                + "as possible without going over.");
            System.out.println("The first cards will now be dealt.\n");
            scan.nextLine();
            Cards card0 = swag.dealFirstCards(player, dealer, playerName);
            boolean giveMeAnother = true;
            while (giveMeAnother
                && (player.getPlayerScore() < 22)) {
                System.out.println("Would you like another card?"
                    + " (1 - yes 2 - no 3 - view stats)");
                int answer = scan.nextInt();
                scan.nextLine();
                if (answer == 1) {
                    swag.hitMePlayer(player, playerName);
                } else if (answer == 3) {
                    System.out.println("You: " + player.getPlayerScore()
                        + " Dealer: " + dealer.getPlayerScore());
                } else {
                    giveMeAnother = false;
                }
            }
            if (player.getPlayerScore() > 21) {
                System.out.println("You lose! Would you like to play again? "
                    + " (1-yes 2-no)");
                int answer = scan.nextInt();
                scan.nextLine();
                if (answer == 2) {
            	    willPlay = false;
                    System.exit(0);
                }
            } else {
                System.out.println("Now it is the dealer's turn!");
                scan.nextLine();
                swag.dealerTurn(dealer, card0);
                while (dealer.getPlayerScore() < 17) {
                    swag.hitMeDealer(dealer);
                    scan.nextLine();
                }
            }
            if (player.getPlayerScore() < 22) {
                if (dealer.getPlayerScore() > 21) {
                    System.out.println("The dealer busted!");
                    System.out.println(playerName + " wins! "
                        + "Would you like to play again (1-yes 2-no)");
                    int answer = scan.nextInt();
                    if (answer == 2) {
                        System.exit(0);
                    }
                } else if (dealer.getPlayerScore() > player.getPlayerScore()) {
                    System.out.println("The dealer will "
                        + "not draw any more cards.");
                    System.out.println("The House wins! "
                        + "Would you like to play again? (1-yes 2-no)");
                    int answer = scan.nextInt();
                    scan.nextLine();
                    if (answer == 2) {
                        System.exit(0);
                    }
                } else if (dealer.getPlayerScore() == player.getPlayerScore()) {
                    System.out.println("The scores are even!");
                    System.out.println("The House wins!"
                        + " Would you like to play again? (1-yes 2-no)");
                    int answer = scan.nextInt();
                    scan.nextLine();
                    if (answer == 2) {
                        System.exit(0);
                    }
                } else {
                    System.out.println("Congrats!");
                    System.out.println(playerName + " wins! "
                        + "Would you like to play again? (1-yes 2-no)");
                    int answer = scan.nextInt();
                    scan.nextLine();
                    if (answer == 2) {
                        System.exit(0);
                    }
                }
            }
            Cards.setDealtCards();
            Cards.setCardCount();
        }
    }

    private Cards dealFirstCards(Player player,
        Player dealer, String playerName) {
    	System.out.println("The first two cards have now been dealt!");
    	Cards card0 = new Cards(false, "The Dealer");
    	Cards card1 = new Cards(true, "The Dealer");
    	Cards card2 = new Cards(true, playerName);
    	Cards card3 = new Cards(true, playerName);
    	player.setPlayerScore(card2.getCardValue());
    	player.setPlayerScore(card3.getCardValue());
    	dealer.setPlayerScore(card1.getCardValueDealer(dealer));
        return card0;
    }

    private void hitMePlayer(Player player, String playerName) {
    	Cards card = new Cards(true, playerName);
        player.setPlayerScore(card.getCardValue());

    }

    private void dealerTurn(Player dealer, Cards card0) {
    	card0.setFaceUp(true);
    	dealer.setPlayerScore(card0.getCardValueDealer(dealer));
    }

    private void hitMeDealer(Player dealer) {
    	Cards card = new Cards(true, "The Dealer");
    	dealer.setPlayerScore(card.getCardValueDealer(dealer));
    }
}