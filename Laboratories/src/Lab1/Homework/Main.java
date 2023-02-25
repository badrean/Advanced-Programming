package Lab1.Homework;

public class Main {
    public static void main(String[] args) {
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
