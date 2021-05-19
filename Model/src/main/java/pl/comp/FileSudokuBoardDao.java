package pl.comp;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Logger;


public class FileSudokuBoardDao implements Dao<SudokuBoard> {
    private String fileName;

    private static final Logger logger = Logger.getLogger(FileSudokuBoardDao.class.getName());

    public FileSudokuBoardDao(String fileName) {
        this.fileName = fileName + ".ser";
    }

    @Override
    public SudokuBoard read() throws IOException, ClassNotFoundException {
        SudokuSolver solver = new BacktrackingSudokuSolver();
        SudokuBoard sudoku = new SudokuBoard(solver);
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            sudoku = (SudokuBoard) in.readObject();
            in.close();
            fileIn.close();
            logger.info("Serialized data is loaded from " + fileName);
        return sudoku;
    }

    @Override
    public void write(SudokuBoard obj) throws IOException {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(obj);
            out.close();
            fileOut.close();
            logger.info("Serialized data is saved in " + fileName);
    }

    @Override
    public void close() throws Exception {

    }
}
