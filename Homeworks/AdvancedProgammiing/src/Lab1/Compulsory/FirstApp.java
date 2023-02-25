package Lab1.Compulsory;

public class FirstApp {
    public static String[] languages = new String[] {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
    public static int n = (int) (Math.random() * 1_000_000);

    public static void compute(){
//        multiply n by 3;
//        add the binary number 10101 to the result;
//        add the hexadecimal number FF to the result;
//        multiply the result by 6;
//        Compute the sum of the digits in the result obtained in the previous step. This is the new result. While the new result has more than one digit, continue to sum the digits of the result.
//        Display on the screen the message: "Willy-nilly, this semester I will learn " + languages[result].
        System.out.println("Initial n value  " + n);
        n = n * 3;
        System.out.println("Multiplied by 3 " + n);
        int defaultBinaryValue = Integer.parseInt("10101", 2);
        int defaultHexValue = Integer.parseInt("FF", 16);

        n = n + defaultBinaryValue;
        System.out.println("Added binary " + n);
        n = n + defaultHexValue;
        System.out.println("Added hex " + n);
        n = n * 6;
        System.out.println("Multiplied by 6 " + n);

        int nCopy = n;
        int result = 0;
        while (nCopy > 0 || result > 9){
            result = result + (nCopy % 10);
            nCopy = nCopy/10;
            if(result > 9 && nCopy == 0){
                nCopy = result;
                result = 0;
            }
        }
        System.out.println("Result " + result);
        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);

    }
    public static void main(String[] args)
    {
        System.out.println("Hello world!");
        FirstApp.compute();
    }
}