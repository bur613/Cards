import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Elevens {

  public static void main(String args[]) {
    Deck myDeck = new Deck();
    myDeck.shuffle();
    ArrayList<Card> myArrayList = new ArrayList<Card>();

    for (int i = 1; i <= 11; i++) {
      myArrayList.add(myDeck.getNextCard());
    }

    for (int i = 0; i <= 10; i++) {
      System.out.println(myArrayList.get(i) + "     Position:" + (i + 1));
    }

    System.out.println(
        "\nRemove any two cards that add to eleven. For example if you wanted to remove\nposition one and two, it would be: 1 2\nTo remove face cards, enter in the position of two different face cards,\nand then enter in the position of the third different face card");
    Scanner kbReader = new Scanner(System.in);

    boolean game = true;

    while (game) {
      System.out.println(myDeck.aryList.size() + " CARDS LEFT");
      int input = 0;
      int in = 0;
      boolean go = true;
      do {
        try {
          input = kbReader.nextInt();
          in = kbReader.nextInt();
          go = false;
        } catch (InputMismatchException e) {
          System.out.println("ONLY INPUT POSITIVE INTEGERS");
          kbReader.next();
        }
      } while (go == true);

      if (input <= myArrayList.size() && input > 0 && in <= myArrayList.size() && in > 0) {
        if (myArrayList.get(input - 1).getValue() + myArrayList.get(in - 1).getValue() == 11) {
          if (myDeck.aryList.size() >= 2) {
            myArrayList.remove(input - 1);
            myArrayList.add(input - 1, myDeck.getNextCard());
            myArrayList.remove(in - 1);
            myArrayList.add(in - 1, myDeck.getNextCard());
            for (int i = 0; i <= myArrayList.size() - 1; i++) {
              System.out.println(myArrayList.get(i) + "     Position:" + (i + 1));
            }
          } else if (myDeck.aryList.size() == 1) {
            myArrayList.remove(input - 1);
            myArrayList.add(input - 1, myDeck.getNextCard());
            myArrayList.remove(in - 1);
            for (int i = 0; i <= myArrayList.size() - 1; i++) {
              System.out.println(myArrayList.get(i) + "     Position:" + (i + 1));
            }
          } else if (myDeck.aryList.size() == 0) {
            myArrayList.remove(input - 1);
            if (input - 1 < in - 1) {
              myArrayList.remove(in - 2);
            } else {
              myArrayList.remove(in - 1);
            }
            for (int i = 0; i <= myArrayList.size() - 1; i++) {
              System.out.println(myArrayList.get(i) + "     Position:" + (i + 1));
            }
          }
        } else if (myArrayList.get(input - 1).getValue() + myArrayList.get(in - 1).getValue()
            >= 23) {
          System.out.println("REMOVE YOUR OTHER FACE CARD");
          int inp = kbReader.nextInt();
          if (myDeck.aryList.size() >= 2) {
            if (myArrayList.get(input - 1).getValue() + myArrayList.get(in - 1).getValue()
                + myArrayList.get(inp - 1).getValue() == 36) {
              myArrayList.remove(input - 1);
              myArrayList.add(input - 1, myDeck.getNextCard());
              myArrayList.remove(in - 1);
              myArrayList.add(in - 1, myDeck.getNextCard());
              myArrayList.remove(inp - 1);
              myArrayList.add(inp - 1, myDeck.getNextCard());
              for (int i = 0; i <= myArrayList.size() - 1; i++) {
                System.out.println(myArrayList.get(i) + "     Position:" + (i + 1));
              }
            } else {
              System.out.println("YOU CAN'T REMOVE THOSE CARDS");
            }
          } else if (myDeck.aryList.size() == 1) {
            if (myArrayList.get(input - 1).getValue() + myArrayList.get(in - 1).getValue()
                + myArrayList.get(inp - 1).getValue() == 36) {
              myArrayList.remove(input - 1);
              myArrayList.add(input - 1, myDeck.getNextCard());
              myArrayList.remove(in - 1);
              if (in - 1 < inp - 1) {
                myArrayList.remove(inp - 2);
              } else {
                myArrayList.remove(inp - 1);
              }
              for (int i = 0; i <= myArrayList.size() - 1; i++) {
                System.out.println(myArrayList.get(i) + "     Position:" + (i + 1));
              }
            } else {
              System.out.println("YOU CAN'T REMOVE THOSE CARDS");
            }
          } else if (myDeck.aryList.size() == 0) {
            if (myArrayList.get(input - 1).getValue() + myArrayList.get(in - 1).getValue()
                + myArrayList.get(inp - 1).getValue() == 36) {
              myArrayList.remove(input - 1);
              if (input - 1 < in - 1) {
                myArrayList.remove(in - 2);
              } else {
                myArrayList.remove(in - 1);
              }
              if ((in - 1 < inp - 1) && (input - 1 < inp - 1)) {
                myArrayList.remove(inp - 3);
              } else if ((in - 1 < inp - 1) && (input - 1 < inp - 1)) {
                myArrayList.remove(inp - 2);
              } else if ((in - 1 < inp - 1) && (input - 1 > inp - 1)) {
                myArrayList.remove(inp - 2);
              } else {
                myArrayList.remove(inp - 1);
              }
              for (int i = 0; i <= myArrayList.size() - 1; i++) {
                System.out.println(myArrayList.get(i) + "     Position:" + (i + 1));
              }
            } else {
              System.out.println("YOU CAN'T REMOVE THOSE CARDS");
            }
          }
        } else {
          System.out.println("THAT DOESN'T ADD TO 11");
        }
      } else {
        System.out.println("THAT IS NOT A VALID POSITION");
      }
      if (myArrayList.size() == 0) {
        System.out.println(
            "CONGRATS! You are the luckiest person in the world!\nI always lose this game :(");
        game = false;
      }
    }
  }
}