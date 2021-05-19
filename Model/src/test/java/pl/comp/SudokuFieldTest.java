package pl.comp;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SudokuFieldTest {

    SudokuField sudokuField = new SudokuField();

    public SudokuFieldTest() {
    }

    @Test
    public void toString_SudokuFieldTest() {
        assertNotNull(sudokuField.toString());


    }

}
