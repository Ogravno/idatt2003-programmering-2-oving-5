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
}
