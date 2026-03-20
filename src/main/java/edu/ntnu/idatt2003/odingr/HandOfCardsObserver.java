package edu.ntnu.idatt2003.odingr;

import edu.ntnu.idatt2003.odingr.models.PlayingCard;

import java.util.List;

public interface HandOfCardsObserver {
  void handChanged(List<PlayingCard> cards);
}
