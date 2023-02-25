package Lab1.Homework;

public class LatinSquare
{
    private int size;
    private int[][] matrix;
    LatinSquare(int n)
    {
        size = n;
        matrix = new int[size][size];
        createLatinSquare();
    }
    public void createLatinSquare(){
        int begginingValue = 0;

        for(int i = 0; i < matrix.length; i++){
            matrix[i][0] = ++begginingValue;
            int valToInsert = begginingValue + 1;
            for(int j = 1; j < matrix[i].length; j++){
                if(valToInsert > size){
                    valToInsert = 1;
                }
                matrix[i][j] = valToInsert;
                valToInsert++;
            }
        }
    }

    public void createLatinSquare(int n){
        size = n;
        matrix = new int[size][size];

        int begginingValue = 0;

        for(int i = 0; i < matrix.length; i++){
            matrix[i][0] = ++begginingValue;
            int valToInsert = begginingValue + 1;
            for(int j = 1; j < matrix[i].length; j++){
                if(valToInsert > size){
                    valToInsert = 1;
                }
                matrix[i][j] = valToInsert;
            }
        }

    }

    public void printLatinSquare(){
        for (int[] row : matrix)
        {
            // traverses through number of rows
            for (int element : row)
            {
                // 'element' has current element of row index
                System.out.print( element  + "  ");
            }
            System.out.println();
        }
    }
}
