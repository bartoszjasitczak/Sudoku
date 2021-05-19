package pl.comp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class SudokuBoardTest {

    public SudokuBoardTest() {
    }


    SudokuBoard sudoku;
    SudokuSolver solver;

    @Test
    public void testSet() {
        solver = new BacktrackingSudokuSolver();
        Observer observer = new Observer();
        sudoku = new SudokuBoard(solver);
        sudoku.addObserver(observer);
        observer.addObservable(sudoku);
        assertEquals(sudoku.get(0, 0), 0);
        sudoku.set(0, 0, 5);
        assertEquals(sudoku.get(0, 0), 5);
    }

    @Test
    public void toString_SudokuBoardTest() {
        SudokuSolver solver = new BacktrackingSudokuSolver();
        Observer observer = new Observer();
        SudokuBoard sudoku = new SudokuBoard(solver);
        sudoku.addObserver(observer);
        observer.addObservable(sudoku);
        sudoku.solveGame();
        assertNotNull(sudoku.toString());


    }

}
