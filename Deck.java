import java.util.ArrayList;

public class Deck {

  ArrayList<Card> aryList = new ArrayList<Card>();

  Deck() {
    for (int i = 1; i <= 10; i++) {
      aryList.add(new Card(String.valueOf(i), "Spades"));
    }
    aryList.add(new Card("Jack", "Spades"));
    aryList.add(new Card("Queen", "Spades"));
    aryList.add(new Card("King", "Spades"));

    for (int i = 1; i <= 10; i++) {
      aryList.add(new Card(String.valueOf(i), "Clubs"));
    }
    aryList.add(new Card("Jack", "Clubs"));
    aryList.add(new Card("Queen", "Clubs"));
    aryList.add(new Card("King", "Clubs"));

    for (int i = 1; i <= 10; i++) {
      aryList.add(new Card(String.valueOf(i), "Hearts"));
    }
    aryList.add(new Card("Jack", "Hearts"));
    aryList.add(new Card("Queen", "Hearts"));
    aryList.add(new Card("King", "Hearts"));

    for (int i = 1; i <= 10; i++) {
      aryList.add(new Card(String.valueOf(i), "Diamonds"));
    }
    aryList.add(new Card("Jack", "Diamonds"));
    aryList.add(new Card("Queen", "Diamonds"));
    aryList.add(new Card("King", "Diamonds"));
  }

  public static void main(String args[]) {
    Deck d = new Deck();
    System.out.println(d);
    d.shuffle();
    System.out.println(d);
  }

  Card getNextCard() {
    return aryList.remove(0);
  }

  void shuffle() {
    for (int i = 104; i >= 0; i--) {
      int swp = (int) (Math.floor(Math.random() * 52));
      int swp2 = (int) (Math.floor(Math.random() * 52));
      swap(swp, swp2);
    }
  }

  void swap(int i, int k) {
    Card temp = aryList.get(i);
    aryList.set(i, aryList.get(k));
    aryList.set(k, temp);
  }

  void reset() {
    aryList.clear();

    for (int i = 1; i <= 10; i++) {
      aryList.add(new Card(String.valueOf(i), "Spades"));
    }
    aryList.add(new Card("Jack", "Spades"));
    aryList.add(new Card("Queen", "Spades"));
    aryList.add(new Card("King", "Spades"));

    for (int i = 1; i <= 10; i++) {
      aryList.add(new Card(String.valueOf(i), "Clubs"));
    }
    aryList.add(new Card("Jack", "Clubs"));
    aryList.add(new Card("Queen", "Clubs"));
    aryList.add(new Card("King", "Clubs"));

    for (int i = 1; i <= 10; i++) {
      aryList.add(new Card(String.valueOf(i), "Hearts"));
    }
    aryList.add(new Card("Jack", "Hearts"));
    aryList.add(new Card("Queen", "Hearts"));
    aryList.add(new Card("King", "Hearts"));

    for (int i = 1; i <= 10; i++) {
      aryList.add(new Card(String.valueOf(i), "Diamonds"));
    }
    aryList.add(new Card("Jack", "Diamonds"));
    aryList.add(new Card("Queen", "Diamonds"));
    aryList.add(new Card("King", "Diamonds"));
  }

  public String toString() {
    String x = "";
    for (Card i : aryList) {
      x += i;
      x += "\n";
    }
    return x;
  }
}

