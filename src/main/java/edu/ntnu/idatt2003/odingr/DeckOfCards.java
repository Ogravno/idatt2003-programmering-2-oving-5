package edu.ntnu.idatt2003.odingr;

import java.util.LinkedList;
import java.util.List;

/**
 * Class representing a deck of cards.
 */
public class DeckOfCards {
  private final char[] suits = { 'S', 'H', 'D', 'C' };
  private final List<String> cards;

  /**
   * Creates a deck of playing cards.
   */
  public DeckOfCards() {
    cards = new LinkedList<>();
    for (char suit : suits) {
      for (int i = 1; i < 14; i++) {
        cards.add(String.valueOf(suit + i));
      }
    }
  }

  public List<String> getCards() {
    return cards;
  }
}
