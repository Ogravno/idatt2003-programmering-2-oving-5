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
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class HandOfCardsView implements HandOfCardsObserver {
  private HandOfCardsController controller;
  private ObservableList<PlayingCard> hand;
  private TableView<PlayingCard> tableView;

  public HandOfCardsView() {}

  public HandOfCardsView(HandOfCardsController controller) {
    this.controller = controller;
  }

  public Scene createView() {
    hand = FXCollections.observableArrayList(); //for automatic UI updates and best practice, we use ObservableList
    tableView = new TableView<>(hand);

    TableColumn<PlayingCard, String> col = new TableColumn<>("Cards:");
    col.setCellValueFactory(cellData ->
        new SimpleStringProperty(cellData.getValue().getAsString()));
    col.setPrefWidth(100);
    tableView.getColumns().add(col);

    Button drawButton = new Button("+");
    drawButton.setOnAction(e -> controller.drawHand());

    VBox root = new VBox(
        new HBox(tableView, drawButton));
    Scene scene = new Scene(root, 350, 400);
    return scene;
  }

  @Override
  public void handChanged(List<PlayingCard> cards) {
    hand.setAll(cards);
  }
}