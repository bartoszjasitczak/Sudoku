package pl.comp;

import java.io.*;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;


public class SudokuField implements Externalizable, Cloneable, Comparable<SudokuField>  {
    private transient IntegerProperty value = new SimpleIntegerProperty(this, "value",0);

    public int getFieldValue() {
        return value.get();
    }

    public IntegerProperty getFieldValueProperty() {
        return value;
    }

    public void setFieldValue(int value) {
        this.value.set(value);
    }



    @Override
    public boolean equals(Object o) {

        SudokuField that = (SudokuField) o;

        return new EqualsBuilder()
                .append(value, that.value)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(value)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "SudokuField{"
                + "value=" + value
                + '}';
    }

    @Override
    public int compareTo(SudokuField o) {
        if (this.getFieldValue() == o.getFieldValue()) {
            return 0;
        } else if (this.getFieldValue() > o.getFieldValue()) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        SudokuField sudokuField = new SudokuField();
        sudokuField.value = this.value;
        return sudokuField;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(value.get());

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        setFieldValue(in.readInt());
    }
}
