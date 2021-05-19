package pl.comp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SudokuFieldGroupTest {
    public SudokuFieldGroupTest() {
    }

    @Test
    public void Equals_HashCode() {
        SudokuSolver solver = new BacktrackingSudokuSolver();
        Observer observer = new Observer();
        SudokuBoard sudoku = new SudokuBoard(solver);
        sudoku.addObserver(observer);
        observer.addObservable(sudoku);
        sudoku.solveGame();

        assertFalse(sudoku.getRow(0).equals(sudoku.getRow(1)));
        assertTrue(sudoku.getRow(0).equals(sudoku.getRow(0)));
        assertTrue(sudoku.getRow(0).hashCode() != sudoku.getRow(1).hashCode());
        assertTrue(sudoku.getRow(0).hashCode() == sudoku.getRow(0).hashCode());

        assertFalse(sudoku.getColumn(0).equals(sudoku.getColumn(1)));
        assertTrue(sudoku.getColumn(0).equals(sudoku.getColumn(0)));
        assertTrue(sudoku.getColumn(0).hashCode() != sudoku.getColumn(1).hashCode());
        assertTrue(sudoku.getColumn(0).hashCode() == sudoku.getColumn(0).hashCode());

        assertFalse(sudoku.getBox(0, 0).equals(sudoku.getBox(3, 3)));
        assertTrue(sudoku.getBox(0, 0).equals(sudoku.getBox(0, 0)));
        assertTrue(sudoku.getBox(0, 0).hashCode() != sudoku.getBox(3, 3).hashCode());
        assertTrue(sudoku.getBox(0, 0).hashCode() == sudoku.getBox(0, 0).hashCode());

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sudoku.set(i, j, 0);
            }
        }

        assertTrue(sudoku.getRow(0).equals(sudoku.getRow(1)));
        assertTrue(sudoku.getColumn(0).equals(sudoku.getColumn(1)));
        assertTrue(sudoku.getBox(0, 0).equals(sudoku.getBox(3, 3)));


        assertTrue(sudoku.getRow(0).hashCode() == sudoku.getRow(1).hashCode());
        assertTrue(sudoku.getColumn(0).hashCode() == sudoku.getColumn(1).hashCode());
        assertTrue(sudoku.getBox(0, 0).hashCode() == sudoku.getBox(3, 3).hashCode());
    }
    @Test
    public void toString_SudokuFieldGroupTest() {
        SudokuSolver solver = new BacktrackingSudokuSolver();
        Observer observer = new Observer();
        SudokuBoard sudoku = new SudokuBoard(solver);
        sudoku.addObserver(observer);
        observer.addObservable(sudoku);
        sudoku.solveGame();
        assertNotNull(sudoku.getBox(0,0).toString());


    }
}
