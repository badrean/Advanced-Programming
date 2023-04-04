package lab7.compulsory;

import java.util.*;

public class Main7Comp {
    public static void main(String[] args) throws InterruptedException {
        Matrix map = new Matrix(4);
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
        Robot robot3 = new Robot("Roboto", map, tokens);

        robot1.start();
        robot2.start();
        robot3.start();

        robot1.join();
        robot2.join();
        robot3.join();

        for(int i = 0; i < map.getSize(); i++){
            for(int j = 0; j < map.getSize(); j++){
                System.out.println(map.getMatrix()[i][j].getId() + " -> " + map.getMatrix()[i][j].getDataList());
            }
        }

        System.out.println("Tokens left: " + tokens);
    }
}
