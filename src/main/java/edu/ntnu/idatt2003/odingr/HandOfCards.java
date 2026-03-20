package edu.ntnu.idatt2003.odingr;

import java.util.List;

public class HandOfCards {
  List<PlayingCard> cards;

  public HandOfCards(List<PlayingCard> cards) {
    this.cards = cards;
  }

  public List<PlayingCard> getCards() {
    return cards;
  }
}
