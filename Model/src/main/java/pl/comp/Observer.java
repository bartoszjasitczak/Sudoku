package pl.comp;


import java.io.Serializable;

public class Observer implements Serializable {
    private SudokuBoard sudokuBoard;

    public void update() {
        sudokuBoard.checkBoard();
    }

    public void addObservable(SudokuBoard sudokuBoard) {
        this.sudokuBoard = sudokuBoard;

    }

}

