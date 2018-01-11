public class Card {

  String kind;
  String suit;

  Card(String a, String b) {
    kind = a;
    suit = b;
  }

  String getKind() {
    return kind;
  }

  String getSuit() {
    return suit;
  }

  int getValue() {
    switch (kind) {
      case "1":
        return 1;
      case "2":
        return 2;
      case "3":
        return 3;
      case "4":
        return 4;
      case "5":
        return 5;
      case "6":
        return 6;
      case "7":
        return 7;
      case "8":
        return 8;
      case "9":
        return 9;
      case "10":
        return 10;
      case "Jack":
        return 11;
      case "Queen":
        return 12;
      case "King":
        return 13;
    }
    return 0;
  }

  boolean isAce() {
    if (kind.equals("1")) {
      return true;
    }
    return false;
  }

  boolean isFace() {
    if (kind.equals("Jack") || kind.equals("Queen") || kind.equals("King")) {
      return true;
    }
    return false;
  }

  public String toString() {
    if (isAce() == true) {
      return "This card is an Ace of " + suit;
    } else {
      return "This card is a " + kind + " of " + suit;
    }
  }
}

