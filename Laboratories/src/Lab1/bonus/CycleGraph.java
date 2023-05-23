package lab1.bonus;

public class CycleGraph {
    private int n;  // number of vertices in the cycle

    public CycleGraph(int n) {
        this.n = n;
    }

    public int[][] adjacencyMatrix() {
        int[][] A = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i - j) % n == 1 || (j - i) % n == 1 || (i == 0 && j == n - 1) || (j == 0 && i == n - 1) ) {
                    A[i][j] = 1;
                } else {
                    A[i][j] = 0;
                }
            }
        }
        return A;
    }

    public int[][] power(int k) {
        int[][] A = adjacencyMatrix();
        int[][] powA = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                powA[i][j] = A[i][j];
            }
        }
        for (int power = 2; power <= k; power++) {
            int[][] tempA = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int m = 0; m < n; m++) {
                        tempA[i][j] += powA[i][m] * A[m][j];
                    }
                }
            }
            powA = tempA;
        }
        return powA;
    }
}