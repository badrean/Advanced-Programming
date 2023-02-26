package lab1.homework;

/**
 * LatinSquare is the class that manages the creation and storage of a
 * latin square.
 *
 * @author Adrian-Paul Bilba
 * @version %I%, %G%
 * @since 1.0
 */
public class LatinSquare
{
    private int size;
    private int[][] matrix;

    /**
     * Class constructor
     * Stores the dimension of the matrix and initializes the matrix.
     * Calls createLatinSquare() to create a latin square from 1 to n.
     *
     * @param n     a natural number > 0 which represents the upper
     *              limit of the latin square
     * @see         #createLatinSquare()
     * @since       1.0
     */
    LatinSquare(int n)
    {
        size = n;
        matrix = new int[size][size];
        createLatinSquare();
    }

    /**
     * Takes the dimension stored in the constructor and the initialized matrix
     * and build the latin square for <i>size</i> elements.
     *
     * @see         #LatinSquare(int)
     * @since       1.0
     */
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

    /**
     * Method used for printing the latin square stored in the memory.
     *
     * @see         #LatinSquare(int)
     * @see         #createLatinSquare()
     * @since       1.0
     */
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
