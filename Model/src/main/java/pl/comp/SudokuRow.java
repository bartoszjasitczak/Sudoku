package pl.comp;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow extends SudokuFieldGroup {

    public SudokuRow(List<SudokuField> fields) {
        super(fields);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        List<SudokuField> fields = new ArrayList<>(getSudokuFieldList());
        return new SudokuRow(fields);
    }

}
