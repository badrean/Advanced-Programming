package lab7.compulsory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cell {
    private final Lock lock = new ReentrantLock();
    private static int count = 0;
    private int id;

    private int line;
    private int column;
    private List<Integer> dataList;

    public Cell(int line, int column) {
        id = count;
        dataList = new ArrayList<>();
        this.line = line;
        this.column = column;
        count++;
    }

    public List<Integer> getDataList() {
        return dataList;
    }

    public void setDataList(List<Integer> dataList) {
        this.dataList = dataList;
    }

    public int getId() {
        return id;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    public static int getCount() {
        return count;
    }

    public Lock getLock() {
        return lock;
    }
}
