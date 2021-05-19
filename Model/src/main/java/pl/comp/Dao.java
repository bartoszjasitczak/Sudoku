package pl.comp;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Dao<T> extends AutoCloseable {
    public T read() throws IOException, ClassNotFoundException;

    public void write(T obj) throws IOException;
}
