package edu.ntnu.idatt2003.odingr.models;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HandOfCardsTest {

  @Test
  void sumFacesEmptyHandReturnsZero() {
    HandOfCards hand = new HandOfCards();

    assertEquals(0, hand.sumFaces());
  }

  @Test
  void sumFacesReturnsCorrectSumForSeveralCards() {
    HandOfCards hand = new HandOfCards();
    hand.setCards(List.of(
        new PlayingCard('H', 1),
        new PlayingCard('S', 7),
        new PlayingCard('D', 13),
        new PlayingCard('C', 10)
    ));

    assertEquals(31, hand.sumFaces());
  }

  @Test
  void getCardsReturnsOnlyCardsOfRequestedSuit() {
    HandOfCards hand = new HandOfCards();
    hand.setCards(List.of(
        new PlayingCard('H', 1),
        new PlayingCard('S', 7),
        new PlayingCard('H', 13),
        new PlayingCard('C', 10)
    ));

    assertEquals(List.of(new PlayingCard('H', 1), new PlayingCard('H', 13)), hand.getCards('H'));
  }

  @Test
  void getCardsReturnsEmptyListWhenSuitDoesNotExistInHand() {
    HandOfCards hand = new HandOfCards();
    hand.setCards(List.of(
        new PlayingCard('H', 1),
        new PlayingCard('S', 7),
        new PlayingCard('H', 13)
    ));

    assertTrue(hand.getCards('D').isEmpty());
  }

  @Test
  void getCardsReturnsEmptyListForEmptyHand() {
    HandOfCards hand = new HandOfCards();

    assertTrue(hand.getCards('S').isEmpty());
  }

  @Test
  void getCardsThrowsForInvalidSuit() {
    HandOfCards hand = new HandOfCards();

    assertThrows(IllegalArgumentException.class, () -> hand.getCards('X'));
  }

  @Test
  void containsQueenOfSpadesReturnsTrueWhenPresent() {
    HandOfCards hand = new HandOfCards();
    hand.setCards(List.of(
        new PlayingCard('S', 12),
        new PlayingCard('H', 4),
        new PlayingCard('D', 9)
    ));

    assertTrue(hand.containsQueenOfSpades());
  }

  @Test
  void containsQueenOfSpadesReturnsFalseWhenNotPresent() {
    HandOfCards hand = new HandOfCards();
    hand.setCards(List.of(
        new PlayingCard('S', 11),
        new PlayingCard('H', 12),
        new PlayingCard('D', 9)
    ));

    assertFalse(hand.containsQueenOfSpades());
  }

  @Test
  void isFlushReturnsTrueWhenAllCardsHaveSameSuit() {
    HandOfCards hand = new HandOfCards();
    hand.setCards(List.of(
        new PlayingCard('C', 2),
        new PlayingCard('C', 7),
        new PlayingCard('C', 10),
        new PlayingCard('C', 13)
    ));

    assertTrue(hand.isFlush());
  }

  @Test
  void isFlushReturnsFalseWhenSuitsDiffer() {
    HandOfCards hand = new HandOfCards();
    hand.setCards(List.of(
        new PlayingCard('C', 2),
        new PlayingCard('C', 7),
        new PlayingCard('H', 10),
        new PlayingCard('C', 13)
    ));

    assertFalse(hand.isFlush());
  }

  @Test
  void isFlushReturnsFalseForEmptyHand() {
    HandOfCards hand = new HandOfCards();

    assertFalse(hand.isFlush());
  }
}