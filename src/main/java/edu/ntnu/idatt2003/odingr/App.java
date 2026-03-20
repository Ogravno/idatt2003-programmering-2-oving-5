package edu.ntnu.idatt2003.odingr;

import edu.ntnu.idatt2003.odingr.models.HandOfCards;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage stage) throws Exception {
    HandOfCards model = new HandOfCards();
    HandOfCardsController controller = new HandOfCardsController(model);
    HandOfCardsView handOfCardsView = new HandOfCardsView(controller);

    // Wire up the observer pattern - App is responsible for connecting Model and View
    model.addObserver(handOfCardsView);

    Scene scene = handOfCardsView.createView();

    stage.setTitle("MVC Table");
    stage.setScene(scene);
    stage.show();
  }
}