package lab7.homework;

import lab7.compulsory.Cell;
import lab7.compulsory.Matrix;
import lab7.compulsory.Robot;

import java.util.*;

public class Main7Hw {
    public static void main(String[] args) throws InterruptedException {
        Matrix map = new Matrix(5);
        for(int i = 0; i < map.getSize(); i++){
            for(int j = 0; j < map.getSize(); j++){
                System.out.println(map.getMatrix()[i][j].getId());
            }
        }

        System.out.println(Cell.getCount());

        List<Integer> tokensList = new LinkedList<>();
        for(int i = 0; i < map.getSize() * map.getSize() * map.getSize(); i++){
            tokensList.add(i);
        }
        System.out.println(tokensList);
        Collections.shuffle(tokensList);
        Queue<Integer> tokens = new LinkedList<>(tokensList);

        Robot robot1 = new Robot("Marcel", map, tokens);
        Robot robot2 = new Robot("Tudor", map, tokens);
//        Robot robot3 = new Robot("Roboto", map, tokens);

//        List<Robot> robots = Arrays.asList(robot1, robot2, robot3);
        List<Robot> robots = Arrays.asList(robot1, robot2);
//        List<Robot> robots = Arrays.asList(robot1);

        RobotController controller = new RobotController(robots);

//        robot1.start();
//        robot2.start();
//        robot3.start();

        controller.waitUserInput();

        controller.joinThreads();

        for(int i = 0; i < map.getSize(); i++){
            for(int j = 0; j < map.getSize(); j++){
                System.out.println(map.getMatrix()[i][j].getId() + " -> " + map.getMatrix()[i][j].getDataList());
            }
        }

        System.out.println("Tokens left: " + tokens);
    }
}
