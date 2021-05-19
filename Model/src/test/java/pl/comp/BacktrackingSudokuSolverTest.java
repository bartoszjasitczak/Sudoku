package pl.comp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BacktrackingSudokuSolverTest {
    public BacktrackingSudokuSolverTest() {
    }


    @Test
    public void testCheckBoard() {
        SudokuSolver solver = new BacktrackingSudokuSolver();
        Observer observer = new Observer();
        SudokuBoard sudoku = new SudokuBoard(solver);
        sudoku.addObserver(observer);
        observer.addObservable(sudoku);
        sudoku.solveGame();
        assertTrue(sudoku.checkBoard());
    }

    @Test
    public void testRow() {
        SudokuSolver solver = new BacktrackingSudokuSolver();
        Observer observer = new Observer();
        SudokuBoard sudoku = new SudokuBoard(solver);
        sudoku.addObserver(observer);
        observer.addObservable(sudoku);
        sudoku.solveGame();
        assertTrue(sudoku.checkBoard());
        int test = sudoku.get(1,0);
        int test_2 = sudoku.get(0,0);
        sudoku.set(0, 0, test);
        sudoku.set(1, 0, test_2);
        assertFalse(sudoku.checkBoard());
        assertFalse(sudoku.getRow(0).verify());

    }

    @Test
    public void testColumn() {
        SudokuSolver solver = new BacktrackingSudokuSolver();
        Observer observer = new Observer();
        SudokuBoard sudoku = new SudokuBoard(solver);
        sudoku.addObserver(observer);
        observer.addObservable(sudoku);
        sudoku.solveGame();
        assertTrue(sudoku.checkBoard());
        int test = sudoku.get(3,0);
        sudoku.set(2,0,test);
        assertFalse(sudoku.checkBoard());
        assertFalse(sudoku.getColumn(0).verify());

    }

    @Test
    public void testBox() {
        SudokuSolver solver = new BacktrackingSudokuSolver();
        Observer observer = new Observer();
        SudokuBoard sudoku = new SudokuBoard(solver);
        sudoku.addObserver(observer);
        observer.addObservable(sudoku);
        sudoku.solveGame();
        assertTrue(sudoku.checkBoard());
        int test = sudoku.get(2,2);
        sudoku.set(1,1,test);
        assertFalse(sudoku.checkBoard());
        assertFalse(sudoku.getBox(0,0).verify());

    }
    @Test
    public void testRepeat_Equals_HashCode() {
        SudokuSolver solver_4 = new BacktrackingSudokuSolver();
        Observer observer = new Observer();
        SudokuBoard sudoku_4 = new SudokuBoard(solver_4);
        sudoku_4.addObserver(observer);
        observer.addObservable(sudoku_4);
        sudoku_4.solveGame();

        SudokuSolver solver_5 = new BacktrackingSudokuSolver();
        Observer observer_2 = new Observer();
        SudokuBoard sudoku_5 = new SudokuBoard(solver_5);
        sudoku_5.addObserver(observer_2);
        observer_2.addObservable(sudoku_5);
        sudoku_5.solveGame();

        assertFalse(sudoku_4.equals(sudoku_5));
        assertTrue(sudoku_4.hashCode() != sudoku_5.hashCode());
        assertTrue(sudoku_4.equals(sudoku_4));
        assertTrue(sudoku_4.hashCode() == sudoku_4.hashCode());
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sudoku_4.set(i, j, sudoku_5.get(i, j));
            }
        }
        assertTrue(sudoku_4.equals(sudoku_5));
        assertTrue(sudoku_4.hashCode() == sudoku_5.hashCode());
    }
}
