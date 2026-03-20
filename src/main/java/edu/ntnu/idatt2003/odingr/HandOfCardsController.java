package edu.ntnu.idatt2003.odingr;

import edu.ntnu.idatt2003.odingr.models.DeckOfCards;
import edu.ntnu.idatt2003.odingr.models.HandOfCards;

public class HandOfCardsController {
  HandOfCards model;
  DeckOfCards deckOfCards;

  public HandOfCardsController(HandOfCards model) {
    this.model = model;
    this.deckOfCards = new DeckOfCards();
  }

  public void drawHand() {
    model.setCards(deckOfCards.dealHand(5));
  }
}
