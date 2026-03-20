package edu.ntnu.idatt2003.odingr.models;

import edu.ntnu.idatt2003.odingr.HandOfCardsObserver;

import java.util.ArrayList;
import java.util.List;

public class HandOfCards {
  private List<PlayingCard> cards;
  private final List<HandOfCardsObserver> observers;

  public HandOfCards() {
    this.cards = new ArrayList<>();
    this.observers = new ArrayList<>();
  }

  public void addObserver(HandOfCardsObserver observer) {
    observers.add(observer);
  }

  public void removeObserver(HandOfCardsObserver observer) {
    observers.remove(observer);
  }

  private void notifyObservers() {
    for (HandOfCardsObserver observer : observers) {
      observer.handChanged(new ArrayList<>(cards));
    }
  }

  public List<PlayingCard> getCards() {
    return cards;
  }

  public void setCards(List<PlayingCard> cards) {
    this.cards = new ArrayList<>(cards);
    notifyObservers();
  }

  public int sumFaces() {
    return cards.stream()
        .map(card -> card.getFace())
        .mapToInt(Integer::intValue)
        .sum();
  }

  public List<PlayingCard> getCards(char suit) {
    if (suit != 'H' && suit != 'D' && suit != 'C' && suit != 'S') {
      throw new IllegalArgumentException("Parameter suit must be one of H, D, C or S");
    }
    return cards.stream()
        .filter(card -> card.getSuit() == suit)
        .toList();
  }

  public boolean containsQueenOfSpades() {
    return cards.stream()
        .anyMatch(card -> card.getSuit() == 'S' && card.getFace() == 12);
  }

  public boolean isFlush() {
    if (cards.isEmpty()) {
      return false;
    }
    char suit = cards.get(0).getSuit();
    return cards.stream()
        .allMatch(card -> card.getSuit() == suit);
  }
}
