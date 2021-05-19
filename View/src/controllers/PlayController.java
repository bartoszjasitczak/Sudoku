package src.controllers;

import javafx.fxml.FXML;
import pl.comp.Dao;
import pl.comp.FileSudokuBoardDao;
import pl.comp.SudokuBoard;
import pl.comp.SudokuBoardDaoFactory;


import java.io.IOException;
import java.util.logging.Logger;

public class PlayController {

    private MainController mainController;

    private static final Logger logger = Logger.getLogger(PlayController.class.getName());

    public void setSudokuBoard(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;
    }

    private SudokuBoard sudokuBoard;

    @FXML
    public void save() {
        SudokuBoardDaoFactory factory = new SudokuBoardDaoFactory();
        try (Dao<SudokuBoard> fileSudokuBoardDao = factory.getFileDao("saved_game")) {
            fileSudokuBoardDao.write(sudokuBoard);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void backMenu() throws IOException {

        mainController.loadChooseDifficultyScreen();
        logger.info("Back to menu");

    }

    public void setMainController(MainController mainController)
    {
        this.mainController = mainController;
    }
}
