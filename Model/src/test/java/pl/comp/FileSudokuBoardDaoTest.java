package pl.comp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FileSudokuBoardDaoTest {


    private SudokuBoardDaoFactory factory = new SudokuBoardDaoFactory();
    SudokuSolver solver = new BacktrackingSudokuSolver();
    private SudokuBoard sudokuBoard = new SudokuBoard(solver);

    private SudokuBoard sudokuBoardSecond;

    @Test
    public void writeReadTest() {

        try (Dao<SudokuBoard> fileSudokuBoardDao = factory.getFileDao("xxx")) {
            fileSudokuBoardDao.write(sudokuBoard);
            sudokuBoardSecond = fileSudokuBoardDao.read();
        } catch (Exception e) {
            e.printStackTrace();
        }


        assertEquals(sudokuBoard, sudokuBoardSecond);
    }

}
