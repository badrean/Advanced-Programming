package lab1.bonus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RegularGraph {
    private int numVertices;
    private int vertexDegree;
    private int[][] adjacencyMatrix;

    public RegularGraph(int numVertices, int vertexDegree) {
        this.numVertices = numVertices;
        this.vertexDegree = vertexDegree;
        this.adjacencyMatrix = new int[numVertices][numVertices];
        buildRegularGraph();
    }

    private void buildRegularGraph() {
        if (vertexDegree >= numVertices || vertexDegree < 1) {
            System.out.println("No regular graph exists with the given parameters.");
            return;
        }

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < vertexDegree / 2; j++) {
                int neighbor = (i + j + 1) % numVertices;
                adjacencyMatrix[i][neighbor] = 1;
                adjacencyMatrix[neighbor][i] = 1;
            }
        }
    }

    public void printRegularGraph() {
        for (int[] row : adjacencyMatrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
