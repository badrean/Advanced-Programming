# Lab 1

### Compulsory (1p)

1. Write a Java application that implements the following operations:  
   Display on the screen the message "Hello World!". Run the application. If it works, go to step 2 :)  
   Define an array of strings languages, containing
   {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"}  
   Generate a random integer n: int n = (int) (Math.random() * 1_000_000);  
   Compute the result obtained after performing the following calculations:
   multiply n by 3;  
   add the binary number 10101 to the result;  
   add the hexadecimal number FF to the result;  
   multiply the result by 6;  
   Compute the sum of the digits in the result obtained in the previous step. This is the new result. While the new
   result has more than one digit, continue to sum the digits of the result.  
   Display on the screen the message: "Willy-nilly, this semester I will learn " + languages[result].


   * Implemented in the laboratory and explained the teacher.

---

### Homework (2p)

1. Let n be an integer given as a command line argument. Validate the argument!  
   Create an n x n Latin Square as a matrix, having as symbols numbers from 1 to n.  
   For each line, and each column of the matrix, create and display on the screen String objects representing the
   concatenation of the symbols in the respective line or column.  
   For larger n display ONLY the running time of the application in nanoseconds or milliseconds. Try n > 30_000. You
   might want to adjust the JVM Heap Space using the VM options -Xms4G -Xmx4G.  
   Launch the application from the command line, for example: java Lab1 9.  


   * Implemented a LatinSquare class which handles the building and printing of the latin square. It builds the first line
   of the matrix from 1 to n and then for the next lines if shifts the numbers to the left by 1 position, resulting
   a latin square.
   
   * Implemented a Main class which is the starting point of the execution of the Java program. It takes a number as a
   parameter and checks if it is really a number. If it doesn't meet this requirement it throws a NumberFormatException.
   It also checks for the number to be greater than 0. In case these 2 requirements are not met, the program exits and
   prints a message to the user. It calls for the constructor of LatinSquare and passes the argument to the constructor. 
   It verifies then if the n passed was > 30_000, in which case it returns the time passed for building the matrix in ms.