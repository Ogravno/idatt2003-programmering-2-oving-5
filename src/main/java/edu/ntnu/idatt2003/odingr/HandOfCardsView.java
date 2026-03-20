package edu.ntnu.idatt2003.odingr;

import java.util.List;

import edu.ntnu.idatt2003.odingr.models.PlayingCard;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class HandOfCardsView implements HandOfCardsObserver {
  private HandOfCardsController controller;
  private ObservableList<PlayingCard> playingCards;
  private TableView<PlayingCard> tableView;
  private Label sumOfFacesLabel;
  private Label cardsOfHeartsLabel;
  private Label isFlushLabel;
  private Label containsQueenOfSpadesLabel;

  public HandOfCardsView() {}

  public HandOfCardsView(HandOfCardsController controller) {
    this.controller = controller;
  }

  public Scene createView() {
    playingCards = FXCollections.observableArrayList();//for automatic UI updates and best practice, we use ObservableList
    tableView = new TableView<>(playingCards);

    TableColumn<PlayingCard, String> col = new TableColumn<>("Cards:");
    col.setCellValueFactory(cellData ->
        new SimpleStringProperty(cellData.getValue().getAsString()));
    col.setPrefWidth(100);
    tableView.getColumns().add(col);
    tableView.setPrefHeight(200);

    Button drawButton = new Button("+");
    drawButton.setOnAction(e -> controller.drawHand());

    String style = "-fx-border-color: black; -fx-border-width: 1px;" +
        "-fx-border-style: solid; padding-right: 20px;";
    sumOfFacesLabel = new Label(String.valueOf(controller.getSumOfFaces()));
    sumOfFacesLabel.setStyle(style);
    cardsOfHeartsLabel = new Label(String.valueOf(controller.hasSuit('H')));
    cardsOfHeartsLabel.setStyle(style);
    isFlushLabel = new Label(String.valueOf(controller.isFlush()));
    isFlushLabel.setStyle(style);
    containsQueenOfSpadesLabel = new Label(String.valueOf(controller.containsQueenOfSpades()));
    containsQueenOfSpadesLabel.setStyle(style);


    VBox handAnalytics = new VBox(
        new HBox(
            new Label("Sum of the faces: "),
            sumOfFacesLabel,
            new Label("Contains hearts: "),
            cardsOfHeartsLabel
        ),
        new HBox(
            new Label("Is flush: "),
            isFlushLabel,
            new Label("Contains queen of spades: "),
            containsQueenOfSpadesLabel
        )
    );

    VBox root = new VBox(
        new HBox(tableView, drawButton),
        handAnalytics);
    Scene scene = new Scene(root, 400, 400);
    return scene;
  }

  @Override
  public void handChanged(List<PlayingCard> cards) {
    playingCards.setAll(cards);
    if (sumOfFacesLabel != null) {
      sumOfFacesLabel.setText(String.valueOf(controller.getSumOfFaces()));
    }
    if (cardsOfHeartsLabel != null) {
      cardsOfHeartsLabel.setText(String.valueOf(controller.hasSuit('H')));
    }
    if (isFlushLabel != null) {
      isFlushLabel.setText(String.valueOf(controller.isFlush()));
    }
    if (containsQueenOfSpadesLabel != null) {
      containsQueenOfSpadesLabel.setText(String.valueOf(controller.containsQueenOfSpades()));
    }
  }
}