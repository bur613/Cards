import java.util.ArrayList;
import java.util.Scanner;

public class Blackjack {

  public static void main(String args[]) {
    Deck BlackjackDeck = new Deck();
    BlackjackDeck.shuffle();

    ArrayList<Card> compHand = new ArrayList<>();
    ArrayList<Card> playerHand = new ArrayList<>();

    ArrayList<Card> splitHand = new ArrayList<>();  //For splits Need to clear every new game

    compHand.add(BlackjackDeck.getNextCard());
    compHand.add(BlackjackDeck.getNextCard());

    playerHand.add(BlackjackDeck.getNextCard());
    playerHand.add(BlackjackDeck.getNextCard());

    System.out
        .println(
            "Welcome to Blackjack! Here are the rules:\nTo win you must have a combined total of 21 in your hand\nAn Ace can either count as a 1 or 11\n"
                + "Face cards are worth 10 each\nDealing: Dealer gives the player two cards one at a time."
                + "\nIf the dealer reaches 21 or if you go over 21, you lose\nYou can Hit to get one more card to get closer to 21, or Stand to stay at the "
                + "cards you have\nThe Computer Dealer has to hit until 17\nGood Luck!\n");

    Scanner kbReader = new Scanner(System.in);
    boolean gameOver = false;
    boolean stayed = false;
    double wins = 0;
    double loses = 0;
    double blackjacks = 0;
    boolean doubDown = false;
    boolean split = false;

    while (!gameOver) {
      int handValue1 = 0;
      int handValue2 = 0;
      int compValue1 = 0;
      int compValue2 = 0;

      int splitValue1 = 0;
      int splitValue2 = 0;

      System.out.println("Dealer's Hand:\n" + compHand.get(0).kind + " of " + compHand.get(0).suit);
      for (int i = 1; i < compHand.size(); i++) {
        if (i == compHand.size() - 1) {
          System.out.println("x\n");
        } else {
          System.out.println("x");
        }
      }

      System.out.println("Your Hand:");
      for (int i = 0; i < playerHand.size(); i++) {
        System.out.println(playerHand.get(i));
      }

      for (Card cHand : compHand) {
        if (cHand.getValue() == 11 || cHand.getValue() == 12 || cHand.getValue() == 13) {
          compValue1 += 10;
        } else {
          compValue1 += cHand.getValue();
        }

        if (cHand.isAce() == true) {
          compValue2 += 11;
        } else if (cHand.getValue() == 11 || cHand.getValue() == 12 || cHand.getValue() == 13) {
          compValue2 += 10;
        } else {
          compValue2 += cHand.getValue();
        }
      }

      for (Card hand : playerHand) {
        if (hand.getValue() == 11 || hand.getValue() == 12 || hand.getValue() == 13) {
          handValue1 += 10;
        } else {
          handValue1 += hand.getValue();
        }

        if (hand.isAce() == true) {
          handValue2 += 11;
        } else if (hand.getValue() == 11 || hand.getValue() == 12 || hand.getValue() == 13) {
          handValue2 += 10;
        } else {
          handValue2 += hand.getValue();
        }
      }

      System.out.println("\nHand Value if Aces are 1: " + handValue1);
      System.out.println("Hand Value if Aces are 11: " + handValue2);

      if (split == true) {
        System.out.println("\nYour 2nd Hand:");
        for (int i = 0; i < splitHand.size(); i++) {
          System.out.println(splitHand.get(i));
        }

        for (Card hand : splitHand) {
          if (hand.getValue() == 11 || hand.getValue() == 12 || hand.getValue() == 13) {
            splitValue1 += 10;
          } else {
            splitValue1 += hand.getValue();
          }

          if (hand.isAce() == true) {
            splitValue2 += 11;
          } else if (hand.getValue() == 11 || hand.getValue() == 12 || hand.getValue() == 13) {
            splitValue2 += 10;
          } else {
            splitValue2 += hand.getValue();
          }
        }
        System.out.println("\n2nd Hand Value if Aces are 1: " + splitValue1);
        System.out.println("2nd Hand Value if Aces are 11 " + splitValue2);
      }

      if (handValue1 > 21) {
        System.out.println("You lose!");
        loses += 1;
        System.out.println("Do you want to play again? Type y for another game and done to exit");
        String in = kbReader.next();
        if (in.equalsIgnoreCase("y")) {
          BlackjackDeck = new Deck();
          BlackjackDeck.shuffle();
          compHand = new ArrayList<>();
          playerHand = new ArrayList<>();
          stayed = false;
          compHand.add(BlackjackDeck.getNextCard());
          compHand.add(BlackjackDeck.getNextCard());
          doubDown = false;

          playerHand.add(BlackjackDeck.getNextCard());
          playerHand.add(BlackjackDeck.getNextCard());
          continue;
        } else if (in.equalsIgnoreCase("done")) {
          gameOver = true;
          break;
        }
      } else if (compValue1 > 21) {
        System.out.println("You win!");
        wins += 1;
        System.out.println("Do you want to play again? Type y for another game and done to exit");
        String in = kbReader.next();
        if (in.equalsIgnoreCase("y")) {
          BlackjackDeck = new Deck();
          BlackjackDeck.shuffle();
          compHand = new ArrayList<>();
          playerHand = new ArrayList<>();
          stayed = false;
          compHand.add(BlackjackDeck.getNextCard());
          compHand.add(BlackjackDeck.getNextCard());
          doubDown = false;

          playerHand.add(BlackjackDeck.getNextCard());
          playerHand.add(BlackjackDeck.getNextCard());
          continue;
        } else if (in.equalsIgnoreCase("done")) {
          gameOver = true;
          break;
        }
      } else if ((handValue1 == 21 || handValue2 == 21) && compValue1 != 21 && compValue2 != 21) {
        System.out.println("You win!");
        wins += 1;
        if (playerHand.size() == 2) {
          blackjacks += 1;
        }
        System.out.println("Do you want to play again? Type y for another game and done to exit");
        String in = kbReader.next();
        if (in.equalsIgnoreCase("y")) {
          BlackjackDeck = new Deck();
          BlackjackDeck.shuffle();
          compHand = new ArrayList<>();
          playerHand = new ArrayList<>();
          stayed = false;
          compHand.add(BlackjackDeck.getNextCard());
          compHand.add(BlackjackDeck.getNextCard());
          doubDown = false;

          playerHand.add(BlackjackDeck.getNextCard());
          playerHand.add(BlackjackDeck.getNextCard());
          continue;
        } else if (in.equalsIgnoreCase("done")) {
          gameOver = true;
          break;
        }
      } else if ((compValue1 == 21 || compValue2 == 21) && handValue1 != 21 && handValue2 != 21) {
        System.out.println("You lose!");
        loses += 1;
        System.out.println("Do you want to play again? Type y for another game and done to exit");
        String in = kbReader.next();
        if (in.equalsIgnoreCase("y")) {
          BlackjackDeck = new Deck();
          BlackjackDeck.shuffle();
          compHand = new ArrayList<>();
          playerHand = new ArrayList<>();
          stayed = false;
          compHand.add(BlackjackDeck.getNextCard());
          compHand.add(BlackjackDeck.getNextCard());
          doubDown = false;

          playerHand.add(BlackjackDeck.getNextCard());
          playerHand.add(BlackjackDeck.getNextCard());
          continue;
        } else if (in.equalsIgnoreCase("done")) {
          gameOver = true;
          break;
        }
      } else if (stayed == true && compValue2 >= 17 && compValue2 <= 21) {
        if (handValue2 > compValue2 && handValue2 <= 21) {
          System.out.println("You win!");
          wins += 1;
          System.out.println("Do you want to play again? Type y for another game and done to exit");
          String in = kbReader.next();
          if (in.equalsIgnoreCase("y")) {
            BlackjackDeck = new Deck();
            BlackjackDeck.shuffle();
            compHand = new ArrayList<>();
            playerHand = new ArrayList<>();
            stayed = false;
            compHand.add(BlackjackDeck.getNextCard());
            compHand.add(BlackjackDeck.getNextCard());
            doubDown = false;

            playerHand.add(BlackjackDeck.getNextCard());
            playerHand.add(BlackjackDeck.getNextCard());
            continue;
          } else if (in.equalsIgnoreCase("done")) {
            gameOver = true;
            break;
          }
        } else if (compValue2 > handValue2 && handValue2 <= 21) {
          System.out.println("You lose!");
          loses += 1;
          System.out.println("Do you want to play again? Type y for another game and done to exit");
          String in = kbReader.next();
          if (in.equalsIgnoreCase("y")) {
            BlackjackDeck = new Deck();
            BlackjackDeck.shuffle();
            compHand = new ArrayList<>();
            playerHand = new ArrayList<>();
            stayed = false;
            compHand.add(BlackjackDeck.getNextCard());
            compHand.add(BlackjackDeck.getNextCard());
            doubDown = false;

            playerHand.add(BlackjackDeck.getNextCard());
            playerHand.add(BlackjackDeck.getNextCard());
            continue;
          } else if (in.equalsIgnoreCase("done")) {
            gameOver = true;
            break;
          }
        } else if (compValue2 < handValue1 && handValue2 > 21) {
          System.out.println("You lose!");
          loses += 1;
          System.out.println("Do you want to play again? Type y for another game and done to exit");
          String in = kbReader.next();
          if (in.equalsIgnoreCase("y")) {
            BlackjackDeck = new Deck();
            BlackjackDeck.shuffle();
            compHand = new ArrayList<>();
            playerHand = new ArrayList<>();
            stayed = false;
            compHand.add(BlackjackDeck.getNextCard());
            compHand.add(BlackjackDeck.getNextCard());
            doubDown = false;

            playerHand.add(BlackjackDeck.getNextCard());
            playerHand.add(BlackjackDeck.getNextCard());
            continue;
          } else if (in.equalsIgnoreCase("done")) {
            gameOver = true;
            break;
          }
        } else if (handValue1 > compValue2 && handValue2 > 21) {
          System.out.println("You win!");
          wins += 1;
          System.out.println("Do you want to play again? Type y for another game and done to exit");
          String in = kbReader.next();
          if (in.equalsIgnoreCase("y")) {
            BlackjackDeck = new Deck();
            BlackjackDeck.shuffle();
            compHand = new ArrayList<>();
            playerHand = new ArrayList<>();
            stayed = false;
            compHand.add(BlackjackDeck.getNextCard());
            compHand.add(BlackjackDeck.getNextCard());
            doubDown = false;

            playerHand.add(BlackjackDeck.getNextCard());
            playerHand.add(BlackjackDeck.getNextCard());
            continue;
          } else if (in.equalsIgnoreCase("done")) {
            gameOver = true;
            break;
          }
        }
      } else if (stayed == true && compValue1 >= 17 && compValue1 <= 21) {
        if (handValue2 > compValue1 && handValue2 <= 21) {
          System.out.println("You win!");
          wins += 1;
          System.out.println("Do you want to play again? Type y for another game and done to exit");
          String in = kbReader.next();
          if (in.equalsIgnoreCase("y")) {
            BlackjackDeck = new Deck();
            BlackjackDeck.shuffle();
            compHand = new ArrayList<>();
            playerHand = new ArrayList<>();
            stayed = false;
            compHand.add(BlackjackDeck.getNextCard());
            compHand.add(BlackjackDeck.getNextCard());
            doubDown = false;

            playerHand.add(BlackjackDeck.getNextCard());
            playerHand.add(BlackjackDeck.getNextCard());
            continue;
          } else if (in.equalsIgnoreCase("done")) {
            gameOver = true;
            break;
          }
        } else if (compValue1 > handValue2 && handValue2 <= 21) {
          System.out.println("You lose!");
          loses += 1;
          System.out.println("Do you want to play again? Type y for another game and done to exit");
          String in = kbReader.next();
          if (in.equalsIgnoreCase("y")) {
            BlackjackDeck = new Deck();
            BlackjackDeck.shuffle();
            compHand = new ArrayList<>();
            playerHand = new ArrayList<>();
            stayed = false;
            compHand.add(BlackjackDeck.getNextCard());
            compHand.add(BlackjackDeck.getNextCard());
            doubDown = false;

            playerHand.add(BlackjackDeck.getNextCard());
            playerHand.add(BlackjackDeck.getNextCard());
            continue;
          } else if (in.equalsIgnoreCase("done")) {
            gameOver = true;
            break;
          }
        } else if (compValue1 < handValue1 && handValue2 > 21) {
          System.out.println("You lose!");
          loses += 1;
          System.out.println("Do you want to play again? Type y for another game and done to exit");
          String in = kbReader.next();
          if (in.equalsIgnoreCase("y")) {
            BlackjackDeck = new Deck();
            BlackjackDeck.shuffle();
            compHand = new ArrayList<>();
            playerHand = new ArrayList<>();
            stayed = false;
            compHand.add(BlackjackDeck.getNextCard());
            compHand.add(BlackjackDeck.getNextCard());
            doubDown = false;

            playerHand.add(BlackjackDeck.getNextCard());
            playerHand.add(BlackjackDeck.getNextCard());
            continue;
          } else if (in.equalsIgnoreCase("done")) {
            gameOver = true;
            break;
          }
        } else if (handValue1 > compValue1 && handValue2 > 21) {
          System.out.println("You win!");
          wins += 1;
          System.out.println("Do you want to play again? Type y for another game and done to exit");
          String in = kbReader.next();
          if (in.equalsIgnoreCase("y")) {
            BlackjackDeck = new Deck();
            BlackjackDeck.shuffle();
            compHand = new ArrayList<>();
            playerHand = new ArrayList<>();
            stayed = false;
            compHand.add(BlackjackDeck.getNextCard());
            compHand.add(BlackjackDeck.getNextCard());
            doubDown = false;

            playerHand.add(BlackjackDeck.getNextCard());
            playerHand.add(BlackjackDeck.getNextCard());
            continue;
          } else if (in.equalsIgnoreCase("done")) {
            gameOver = true;
            break;
          }
        }
      }

      if (doubDown == true) {
        if (handValue2 > compValue2) {
          System.out.println("You win!");
          wins += 2;
          System.out.println("Do you want to play again? Type y for another game and done to exit");
          String in = kbReader.next();
          if (in.equalsIgnoreCase("y")) {
            BlackjackDeck = new Deck();
            BlackjackDeck.shuffle();
            compHand = new ArrayList<>();
            playerHand = new ArrayList<>();
            stayed = false;
            compHand.add(BlackjackDeck.getNextCard());
            compHand.add(BlackjackDeck.getNextCard());
            doubDown = false;
            playerHand.add(BlackjackDeck.getNextCard());
            playerHand.add(BlackjackDeck.getNextCard());
            continue;
          } else if (in.equalsIgnoreCase("done")) {
            gameOver = true;
            break;
          }
        } else if (handValue2 < compValue2) {
          System.out.println("You win!");
          wins += 2;
          System.out.println("Do you want to play again? Type y for another game and done to exit");
          String in = kbReader.next();
          if (in.equalsIgnoreCase("y")) {
            BlackjackDeck = new Deck();
            BlackjackDeck.shuffle();
            compHand = new ArrayList<>();
            playerHand = new ArrayList<>();
            stayed = false;
            compHand.add(BlackjackDeck.getNextCard());
            compHand.add(BlackjackDeck.getNextCard());
            doubDown = false;
            playerHand.add(BlackjackDeck.getNextCard());
            playerHand.add(BlackjackDeck.getNextCard());
            continue;
          } else if (in.equalsIgnoreCase("done")) {
            gameOver = true;
            break;
          }
        }
      }

      if (playerHand.get(0).getKind().equals(playerHand.get(1).getKind())) {
        System.out.println(
            "Do you want to split? You are splitting your hand in two and you are dealt 1 more card for each hand and play them separately. Type y or no");
        String splitCards = kbReader.next();
        if (splitCards.equalsIgnoreCase("y")) {
          splitHand.add(playerHand.remove(1));
          splitHand.add(BlackjackDeck.getNextCard());
          playerHand.add(BlackjackDeck.getNextCard());
          split = true;
        }
      }

      if ((handValue1 == 11 || handValue2 == 11) && playerHand.size() == 2) {
        System.out.println(
            "Do you want to double down? You get one more card, and it counts as 2 wins and 2 losses. Type y or no");
        String doubleDown = kbReader.next();
        if (doubleDown.equalsIgnoreCase("y")) {
          playerHand.add(BlackjackDeck.getNextCard());
          doubDown = true;
          continue;
        }
      }

      System.out.println("Hit or Stay?");

      String input;
      if (stayed == false) {
        input = kbReader.next();
      } else {
        input = "stay";
      }

      if (input.equalsIgnoreCase("Hit") || input.equalsIgnoreCase("Stay")) {
        if (input.equalsIgnoreCase("Hit")) {
          playerHand.add(BlackjackDeck.getNextCard());
        }
        if (input.equalsIgnoreCase("Stay")) {
          if (compValue1 == 17 || compValue2 == 17) {

          } else if (compValue1 == handValue1 || compValue2 == handValue2
              || compValue2 == handValue1 || compValue1 == handValue2) {
            System.out.println("You tied! This is a push!");
            gameOver = true;
          } else {
            compHand.add(BlackjackDeck.getNextCard());
          }
          stayed = true;
        }
      }
      if (input.equals("show")) {
        for (int i = 0; i < compHand.size(); i++) {
          System.out.println(compHand.get(i));
        }
        System.out.println(compValue1 + " " + compValue2);
      }
    }

    System.out.println(
        "Wins: " + wins / (wins + loses) * 100 + "%\nLoses: " + loses / (wins + loses) * 100
            + "%\nBlackjacks: "
            + blackjacks / (wins + loses) * 100 + "%");
  }
}
