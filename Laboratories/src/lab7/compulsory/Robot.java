package lab7.compulsory;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Robot extends Thread {
    private Matrix matrix;
    private String name;
    private int numberOfTokensPlaced;
    static private final Lock pauseLock = new ReentrantLock();
    static private final Lock tokensQueueLock = new ReentrantLock();
    private Queue<Integer> tokensQueue;
    static private final Lock unvisitedCellsLock = new ReentrantLock();
    private static Stack<Integer> unvisitedCells;
    private final AtomicBoolean isRunning = new AtomicBoolean(false);
    private boolean isPaused;
    public Robot(String name, Matrix matrix, Queue<Integer> tokensQueue) {
        this.name = name;
        this.matrix = matrix;
        numberOfTokensPlaced = 0;
        this.tokensQueue = tokensQueue;
        isPaused = false;
        if (unvisitedCells == null){
            unvisitedCells = new Stack<>();
            for(int i = 0; i < matrix.getSize() * matrix.getSize(); i++){
                unvisitedCells.push(i);
            }
            Collections.shuffle(unvisitedCells);
        }
    }
    @Override
    public void run() {
        isRunning.set(true);
        while(!unvisitedCells.empty() && isRunning.get()) {
            if(!isPaused) {
                Cell currentCell = extractUnvisitedCell();

                if(currentCell.getLine() > -1 && currentCell.getColumn() > -1) {
                    currentCell.getLock().lock();
                    try {
//                    System.out.println(getRobotName() + ": Visiting cell (" + currentCell.getId() + ")");
                        visitCell(currentCell); //marks the cell as visited and updates tokens if the cell was not visited before
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        currentCell.getLock().unlock();
                    }
                }
            }
        }
        isRunning.set(false);
        System.out.println(getRobotName() + " finished the job and placed " + numberOfTokensPlaced + " tokens.");
    }

    private Cell extractUnvisitedCell(){
        Cell cell = new Cell(-1,-1);
        unvisitedCellsLock.lock();
        try {
            if (!unvisitedCells.empty()) return matrix.getCellById(unvisitedCells.pop());
        } finally {
            unvisitedCellsLock.unlock();
        }
        return cell;
    }
    private void visitCell(Cell cell) throws InterruptedException {
        updateCell(cell);
    }
    private synchronized @NotNull List<Integer> extractTokens() {
        List<Integer> retList = new ArrayList<>();

        for(int i = 0; i < matrix.getSize(); i++) {
            retList.add(tokensQueue.remove());
        }

        return retList;
    }

    private void updateCell(Cell cell) throws InterruptedException {
        unvisitedCellsLock.lock();
        try {
            List<Integer> tokenList = extractTokens();
            cell.setDataList(tokenList);
            numberOfTokensPlaced += tokenList.size();
//        System.out.println(getRobotName() + ": Updated cell (" + cell.getId() + ")");
            sleep(500);
        } finally {
            unvisitedCellsLock.unlock();
        }
    }

    public Matrix getMatrix() {
        return matrix;
    }

    public String getRobotName() {
        return name;
    }

    public static Stack<Integer> getUnvisitedCells() {
        return unvisitedCells;
    }

    public boolean isRunning() {
        return isRunning.get();
    }

    public void setRunning(boolean running) {
        isRunning.set(running);
    }

    public void setPaused(boolean paused) {
        isPaused = paused;
    }

    public boolean isPaused() {
        return isPaused;
    }
}
