package src.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;
import pl.comp.*;
import pl.comp.gui.App;

import java.io.IOException;
import java.util.Random;
import java.util.logging.Logger;

public class ChooseDifficultyController {

    private MainController mainController;
    private Difficulties difficulty;
    private SudokuBoard sudokuBoard;

    private static final Logger logger = Logger.getLogger(ChooseDifficultyController.class.getName());



    @FXML
    public void Easy() throws IOException {

        difficulty=Difficulties.EASY;
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/PlayScreen.fxml"));
        Pane pane = loader.load();
        setPlay(pane);

        PlayController playController = loader.getController();
        playController.setMainController(mainController);
        mainController.setScreen(pane);
        playController.setSudokuBoard(sudokuBoard);

        logger.info("Easy level set");



    }
    @FXML
    public void Medium() throws IOException {

        difficulty=Difficulties.MEDIUM;

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/PlayScreen.fxml"));
        Pane pane = loader.load();
        setPlay(pane);

        PlayController playController = loader.getController();
        playController.setMainController(mainController);
        mainController.setScreen(pane);
        playController.setSudokuBoard(sudokuBoard);

        logger.info("Medium level set");

    }
    @FXML
    public void Hard() throws IOException {

        difficulty=Difficulties.HARD;

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/PlayScreen.fxml"));
        Pane pane = loader.load();
        setPlay(pane);

        PlayController playController = loader.getController();
        playController.setMainController(mainController);
        mainController.setScreen(pane);
        playController.setSudokuBoard(sudokuBoard);

        logger.info("Hard level set");

    }

    private void setPlay(Pane pane) {

        Observer observer = new Observer();
        SudokuSolver solver = new BacktrackingSudokuSolver();
        sudokuBoard = new SudokuBoard(solver);
        sudokuBoard.addObserver(observer);
        observer.addObservable(sudokuBoard);
        sudokuBoard.solveGame();


        switch (difficulty){
            case EASY:
                eraseNumbers(10,sudokuBoard);
                break;
            case MEDIUM:
                eraseNumbers(20,sudokuBoard);
                break;
            case HARD:
                eraseNumbers(30,sudokuBoard);
                break;
        }



        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                TextField text = new TextField();
                text.textProperty().bindBidirectional(sudokuBoard.getField( i, j).getFieldValueProperty(), new NumberStringConverter());

                Node node = pane.getChildren().get(0);
                if (node instanceof GridPane) {
                    ((GridPane) node).add(text,i,j);
                }
            }
        }


    }

    @FXML
    public void load() throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/PlayScreen.fxml"));
        Pane pane = loader.load();
        SudokuBoardDaoFactory factory = new SudokuBoardDaoFactory();

        try (Dao<SudokuBoard> fileSudokuBoardDao = factory.getFileDao("saved_game")) {
            sudokuBoard = fileSudokuBoardDao.read();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    TextField text = new TextField();
                    text.textProperty().bindBidirectional(sudokuBoard.getField( i, j).getFieldValueProperty(), new NumberStringConverter());

                    Node node = pane.getChildren().get(0);
                    if (node instanceof GridPane) {
                        ((GridPane) node).add(text,i,j);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        PlayController playController = loader.getController();
        playController.setMainController(mainController);
        mainController.setScreen(pane);
        playController.setSudokuBoard(sudokuBoard);

    }

    private void eraseNumbers(int HowManyNumbers,SudokuBoard sudokuBoard) {

        Random rand = new Random();
        int x, y;
        boolean removed;
        for (int i = 0; i < HowManyNumbers; i++) {
            removed = false;
            while (removed == false) {
                x = rand.nextInt(8);
                y = rand.nextInt(8);
                if (sudokuBoard.get(x, y) != 0) {
                    sudokuBoard.set(x, y, 0);
                    removed = true;

                }
            }
        }
    }



    @FXML
    public void backMenu() throws IOException {

        mainController.loadMenuScreen();
        logger.info("Back to menu");

    }

    public void setMainController(MainController mainController)
    {
        this.mainController = mainController;
    }
}
