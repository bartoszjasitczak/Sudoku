package pl.comp;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BacktrackingSudokuSolver implements SudokuSolver, Serializable {

    @Override
    public void solve(SudokuBoard board) {
         Random rand = new Random();
        List<Integer> tab = Arrays.asList(new Integer[81]);
         for (int i = 0; i < 81; i++) {

             int line = i / 9;
             int column = i % 9;

             boolean ok = false;
             if (board.get(line, column) == 0) {
                int x = rand.nextInt(9) + 1;
                 tab.set(i, x);
                 board.set(line, column, tab.get(i));
                do {
                     if (isItOk(line, column, board)) {
                         ok = true;
                         break;
                    }
                     board.set(line, column, board.get(line, column) % 9 + 1);
                 } while (board.get(line, column) != tab.get(i));
            } else {
                 board.set(line, column, board.get(line, column) % 9 + 1);
                 while (board.get(line, column) != tab.get(i)) {
                     if (isItOk(line, column, board)) {
                         ok = true;
                         break;
                    }
                     board.set(line, column, board.get(line, column) % 9 + 1);
                }
            }

             if (!ok) {
                 board.set(line, column, 0);
                 i -= 2;
            }
        }
     }

     private boolean isItOk(int x, int y, SudokuBoard board) {
         for (int j = 0; j < 9; j++) {
            if (board.get(x, y) == board.get(x, j)) {
                if (y != j) {
                    return false;
                 }
            }
             if (board.get(x, y) == board.get(j, y)) {
                 if (x != j) {
                     return false;
                 }
            }
             if (board.get(x, y) == board.get(x / 3 * 3 + j % 3, y / 3 * 3 + j / 3)) {
                 if (x != x / 3 * 3 + j % 3 && y != y / 3 * 3 + j / 3) {
                     return false;
                 }
             }
        }
        return true;
    }

}
