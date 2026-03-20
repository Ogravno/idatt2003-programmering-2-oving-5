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

  public int getSumOfFaces() {
    return model.sumFaces();
  }

  public boolean hasSuit(char suit) {
    return !model.getCards(suit).isEmpty();
  }

  public boolean isFlush() {
    return model.isFlush();
  }

  public  boolean containsQueenOfSpades() {
    ;return  model.containsQueenOfSpades();
  }
}
