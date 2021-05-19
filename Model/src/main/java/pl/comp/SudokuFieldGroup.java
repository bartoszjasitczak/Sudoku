package pl.comp;

import java.io.Serializable;
import  java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;



public class SudokuFieldGroup implements Cloneable, Serializable {

    protected List<SudokuField> fields = Arrays.asList(new SudokuField[9]);

    public SudokuFieldGroup(List<SudokuField> fields) {
        this.fields = fields;
    }

    public List<SudokuField> getSudokuFieldList() {
        return Collections.unmodifiableList(fields);
    }

    public boolean verify() {
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (fields.get(i).getFieldValue() == fields.get(j).getFieldValue()) {
                    return false;
                }
            }

        }
        return true;
    }

    @Override
    public boolean equals(Object o) {

        SudokuFieldGroup that = (SudokuFieldGroup) o;

        return new EqualsBuilder()
                .append(fields, that.fields)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(fields)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "SudokuFieldGroup{"
                + "fields=" + fields
                + '}';
    }
}
