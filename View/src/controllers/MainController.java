package src.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.io.IOException;


public class MainController {

    @FXML
    private StackPane MainStackPane;

    @FXML
    public void initialize() throws IOException {
        loadMenuScreen();
    }

    public void loadMenuScreen() throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/MenuScreen.fxml"));
        Pane pane = loader.load();
        MenuController menuController = loader.getController();
        menuController.setMainController(this);
        setScreen(pane);
    }

    public void loadChooseDifficultyScreen() throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/ChooseDifficulty.fxml"));
        Pane pane = loader.load();
        ChooseDifficultyController chooseDifficultyController = loader.getController();
        chooseDifficultyController.setMainController(this);
        setScreen(pane);
    }

    public void setScreen(Pane pane) {
        MainStackPane.getChildren().clear();
        MainStackPane.getChildren().add(pane);
    }

}
