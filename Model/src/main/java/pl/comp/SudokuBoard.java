package pl.comp;


import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import  org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;





public class SudokuBoard implements Serializable, Cloneable {


    private SudokuSolver solver;
    private SudokuField[][] board;
    private Observer observer;

    public SudokuSolver getSolver() {
        return solver;
    }

    public SudokuBoard(SudokuSolver newsolver) {
        solver = newsolver;
        board = new SudokuField[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = new SudokuField();
            }
        }

    }

    public void addObserver(Observer observer) {
        this.observer = observer;
    }

    public int get(int x, int y) {
        return board[x][y].getFieldValue();
     }

    public void set(int x, int y, int i) {
        board[x][y].setFieldValue(i);
        observer.update();
     }

    public void solveGame() {
        solver.solve(this);
     }

    boolean checkBoard() {
        for (int i = 0; i < 9; i = i + 3) {
            for (int j = 0; j < 9; j = j + 3) {
                if (!getBox(i, j).verify()) {
                    return false;
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            if (!getColumn(i).verify()) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (!getRow(i).verify()) {
                return false;
            }
        }

         return true;
    }

    public SudokuRow getRow(int row) {
        List<SudokuField> fields = Arrays.asList(new SudokuField[9]);
        for (int i = 0; i < 9; i++) {
            fields.set(i, board[row][i]);
        }
        return new SudokuRow(fields);
    }

    public SudokuColumn getColumn(int column) {
        List<SudokuField> fields = Arrays.asList(new SudokuField[9]);
        for (int i = 0; i < 9; i++) {
            fields.set(i, board[i][column]);
        }
        return new SudokuColumn(fields);
    }

    public SudokuBox getBox(int rowIndex, int columnIndex) {
        List<SudokuField> fields = Arrays.asList(new SudokuField[9]);
        int h = 0;
        for (int i = 0; i < 9; i++) {
                fields.set(i, board[rowIndex / 3 * 3 + h % 3][columnIndex / 3 * 3 + h / 3]);
                h++;
        }
        return new SudokuBox(fields);
    }

    @Override
    public boolean equals(final Object o) {

        SudokuField [] tab = new SudokuField[81];
        SudokuField [] tab2 = new SudokuField[81];
        int x = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                tab[x] = board[i][j];
                tab2[x] = ((SudokuBoard) o).board[i][j];
                x++;
            }
        }
        return new EqualsBuilder().append(tab, tab2).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(board)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "SudokuBoard{"
                + "solver=" + solver
                + ", board=" + Arrays.toString(board)
                + ", observer=" + observer
                + '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        solver = new BacktrackingSudokuSolver();
        SudokuBoard sudokuBoard = new SudokuBoard(solver);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sudokuBoard.set(i, j, get(i, j));
            }
        }

        return sudokuBoard;
    }

    public SudokuField getField(int i, int j) {
        return board[i][j];
    }
}