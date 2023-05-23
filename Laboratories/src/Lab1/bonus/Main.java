package lab1.bonus;

import java.util.Arrays;
public class Main {
    public static void main(String[] args) {

        CycleGraph cg = new CycleGraph(5);  // create cycle graph C5
        int[][] initialMatrix = cg.adjacencyMatrix();

        System.out.println("A^" + 1 + ":");
        for (int[] row : initialMatrix) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println();
        for (int i = 2; i <= 5; i++) {
            int[][] powCg = cg.power(i);
            System.out.println("A^" + i + ":");
            for (int[] row : powCg) {
                System.out.println(Arrays.toString(row));
            }
        }

        RegularGraph rg = new RegularGraph(8, 2);
        System.out.println("\nRegular graph:");
        rg.printRegularGraph();
    }
}