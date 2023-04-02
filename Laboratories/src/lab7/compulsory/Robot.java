package lab7.compulsory;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Robot extends Thread {
    private Matrix matrix;
    private String name;
    private Queue<Integer> tokensQueue;
    static private final Lock visitedCellsLock = new ReentrantLock();
    private static Set<Integer> visitedCells = new HashSet<>();
    public Robot(String name, Matrix matrix, Queue<Integer> tokensQueue) {
        this.name = name;
        this.matrix = matrix;
        this.tokensQueue = tokensQueue;
    }
    @Override
    public void run() {
        while(visitedCells.size() < matrix.getSize() * matrix.getSize()) {
            Random random = new Random();
            int maxNumberOfCells = Cell.getCount();

            Cell currentCell = matrix.getCellById(random.nextInt(maxNumberOfCells));
            currentCell.getLock().lock();
            try {
                System.out.println(getRobotName() + ": Visiting cell (" + currentCell.getId() + ")");
                visitCell(currentCell); //marks the cell as visited and updates tokens if the cell was not visited before
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                currentCell.getLock().unlock();
            }
        }
    }

    private void visitCell(Cell cell) throws InterruptedException {
        synchronized (visitedCellsLock) {
            if (!visitedCells.contains(cell.getId())) {
                visitedCells.add(cell.getId());
                updateCell(cell);
            }
            else {
                System.out.println(getRobotName() + ": Cell (" + cell.getId() + ") already visited");
                sleep(500);
            }
        }
    }
    private synchronized @NotNull List<Integer> extractTokens() {
        List<Integer> retList = new ArrayList<>();

        for(int i = 0; i < matrix.getSize(); i++) {
            retList.add(tokensQueue.remove());
        }

        return retList;
    }

    private void updateCell(Cell cell) throws InterruptedException {
        List<Integer> tokenList = extractTokens();
        cell.setDataList(tokenList);
        System.out.println(getRobotName() + ": Updated cell (" + cell.getId() + ")");
        sleep(500);
    }


    public Matrix getMatrix() {
        return matrix;
    }

    public String getRobotName() {
        return name;
    }
}
