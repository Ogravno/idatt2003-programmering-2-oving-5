package edu.ntnu.idatt2003.odingr;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
   *
   * <p>Deck contains 52 cards</p>
   */
  public DeckOfCards() {
    cards = new ArrayList<>();

    for (char suit : suits) {
      for (int i = 1; i < 14; i++) {
        cards.add(suit + String.valueOf(i));
      }
    }
  }

  public List<String> getCards() {
    return cards;
  }

  /**
   * Deals a hand.
   *
   * @param n the number of cards in the hand. Must be at least 5 and cannot be greater than the
   *          number of cards in the deck.
   * @return the dealt hand as a {@link List} of cards
   */
  public List<String> dealHand(int n) {
    if (n < 5 | n > cards.size()) {
      throw new IllegalArgumentException("invalid number of cards");
    }

    List<String> cardsCopy = new ArrayList<>(cards);
    Collections.shuffle(cardsCopy);
    return cardsCopy.stream()
        .limit(n)
        .toList();
  }
}
