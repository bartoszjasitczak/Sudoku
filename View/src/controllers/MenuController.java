package src.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.converter.NumberStringConverter;
import pl.comp.*;

import java.io.IOException;
import java.util.logging.Logger;

public class MenuController {
    private MainController mainController;

    private static final Logger logger = Logger.getLogger(MenuController.class.getName());

    @FXML
    public void Play() throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/ChooseDifficulty.fxml"));
        Pane pane = loader.load();
        ChooseDifficultyController chooseDifficultyController = loader.getController();
        chooseDifficultyController.setMainController(mainController);
        mainController.setScreen(pane);

    }



    @FXML
    public void Exit(){
        Platform.exit();
        logger.info("Exit");


    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
