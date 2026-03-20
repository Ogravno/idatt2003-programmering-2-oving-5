package edu.ntnu.idatt2003.odingr;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DeckOfCardsTest {

  @BeforeEach
  void setUp() {
  }

  @Test
  void constructorCreates52Cards() {
    DeckOfCards cardDeck = new DeckOfCards();
    assertEquals(52, cardDeck.getCards().size());
  }
}