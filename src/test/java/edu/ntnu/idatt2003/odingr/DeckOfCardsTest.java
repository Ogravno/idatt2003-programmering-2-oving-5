package edu.ntnu.idatt2003.odingr;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

class DeckOfCardsTest {
  DeckOfCards deckOfCards;

  @BeforeEach
  void setUp() {
    deckOfCards = new DeckOfCards();
  }

  @Test
  void constructorCreates52Cards() {
    DeckOfCards cardDeck = new DeckOfCards();
    assertEquals(52, cardDeck.getCards().size());
    assertEquals("S1", cardDeck.getCards().getFirst());
  }

  @Nested
  class DealHandTests {
    @Test
    void dealHandInvalidNumberOfCards() {
      assertThrows(IllegalArgumentException.class, () -> deckOfCards.dealHand(4));
      assertThrows(IllegalArgumentException.class, () -> deckOfCards.dealHand(53));
    }

    @Test
    void dealHandDealsHand() {
      List<String> hand = deckOfCards.dealHand(5);
      assertEquals(5, hand.size());
    }

    @Test
    void dealHandDealsUniqueHand() {
      List<String> hand = deckOfCards.dealHand(5);
      List<String> uniqueHand = hand.stream().distinct().toList();
      assertEquals(uniqueHand.size(), hand.size());
    }
  }
}