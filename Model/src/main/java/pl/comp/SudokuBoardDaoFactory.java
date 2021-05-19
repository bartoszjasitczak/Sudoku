package pl.comp;


public class SudokuBoardDaoFactory {

    public Dao<SudokuBoard> getFileDao(String fileName) {
        return new FileSudokuBoardDao(fileName);
    }
}
