package lab1.homework;

import org.jetbrains.annotations.NotNull;

/**
 * Main is the starting point for JVM to start execution of the Java program.
 * It creates the LatinSquare object with the number given by the user and calls
 * the print method of the class to print on the screen the latin square.
 * It also checks if the number given is > 30_000, in which case it won't print
 * the latin square, but it will just print the time taken to build the square
 * in ms.
 *
 * @author Adrian-Paul Bilba
 * @version %I%, %G%
 * @since 1.0
 */
public class Main {

    /**
     * Public main method, which takes the number parameter given in the command line and
     * handles the creation of the LatinSquare object, the verification if the n number and
     * calls the print method for the latin square.
     * The method checks if the parameter given is a number and if it's > 0. If the argument
     * doesn't meet these requirements, the program stops and prints a message to the user.
     *
     * @param args      a natural number > 0 which represents the upper
     *                  limit of the latin square
     * @see             LatinSquare
     * @since           1.0
     */
    public static void main(String @NotNull [] args) {
        long start = System.currentTimeMillis();
        int n = 0;
        try {
            n = Integer.parseInt(args[0]);
        } catch (NumberFormatException exception) {
            System.out.println("Enter a number");
            System.exit(1);
        }

        if (n <= 0) {
            System.out.println("Enter a value greater than 0");
            System.exit(1);
        }

        LatinSquare patrat = new LatinSquare(n);

        long end = System.currentTimeMillis();

        if (n > 30000) {
            System.out.println(end-start + " ms");
        } else {
            patrat.printLatinSquare();
        }
    }

}
