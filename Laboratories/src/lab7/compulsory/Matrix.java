package lab7.compulsory;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class Matrix {
    private int size;
    private Cell[][] matrix;

    public Matrix(int size) {
        this.size = size;
        matrix = new Cell[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                matrix[i][j] = new Cell(i, j);
            }
        }
    }

    public Cell[][] getMatrix() {
        return matrix;
    }

    public Cell getCellById(int id) {
        Cell returningCell = null;

        try {
            if(Cell.getCount() <= id || id < 0) throw new IndexOutOfBoundsException();

            for(int i = 0; i < size; i++){
                for(int j = 0; j < size; j++){
                    if (matrix[i][j].getId() == id)
                        returningCell = matrix[i][j];
                }
        }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return returningCell;
    }

    public int getSize() {
        return size;
    }
}
