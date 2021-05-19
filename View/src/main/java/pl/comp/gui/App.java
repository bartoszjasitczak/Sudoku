package pl.comp.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import pl.comp.Difficulties;
import java.util.ResourceBundle;
import java.util.logging.Logger;


public class App extends Application {

//    private static Difficulties difficulty;
//
//    public static void setDifficulty(Difficulties difficulty_new) {
//        difficulty = difficulty_new;
//    }
//
    public static void main(String[] args){
        launch(args);
    }

    private static final Logger logger = Logger.getLogger(App.class.getName());

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/MainScreen.fxml"));
        StackPane stackPane = loader.load();
        Scene scene = new Scene(stackPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Sudoku");
        primaryStage.show();
        logger.info("Start application!");



    }

}
