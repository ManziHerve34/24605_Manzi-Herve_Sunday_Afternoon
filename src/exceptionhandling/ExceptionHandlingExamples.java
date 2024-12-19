
package exceptionhandling;


import java.io.*;
import java.sql.*;

public class ExceptionHandlingExamples {

    // 1. IOException
    public static void simulateIOException() {
        try {
            FileReader file = new FileReader("nonexistent_file.txt");
        } catch (IOException e) {
            System.out.println("IOException caught: " + e.getMessage());
        }
    }

    // 2. FileNotFoundException
    public static void simulateFileNotFoundException() {
        try {
            FileInputStream file = new FileInputStream("missing_file.txt");
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException caught: " + e.getMessage());
        }
    }

    // 3. EOFException
    public static void simulateEOFException() {
        try (DataInputStream input = new DataInputStream(new FileInputStream("testfile.dat"))) {
            while (true) {
                input.readUTF(); // Reading beyond the file's content
            }
        } catch (EOFException e) {
            System.out.println("EOFException caught: End of file reached.");
        } catch (IOException e) {
            System.out.println("IOException caught: " + e.getMessage());
        }
    }

    // 4. SQLException
    public static void simulateSQLException() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:invalid:database");
        } catch (SQLException e) {
            System.out.println("SQLException caught: " + e.getMessage());
        }
    }

    // 5. ClassNotFoundException
    public static void simulateClassNotFoundException() {
        try {
            Class.forName("com.nonexistent.ClassName");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException caught: " + e.getMessage());
        }
    }

    // 6. ArithmeticException
    public static void simulateArithmeticException() {
        try {
            int result = 10 / 0; // Division by zero
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException caught: " + e.getMessage());
        }
    }

    // 7. NullPointerException
    public static void simulateNullPointerException() {
        try {
            String str = null;
            str.length(); // Accessing a null reference
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught: " + e.getMessage());
        }
    }

    // 8. ArrayIndexOutOfBoundsException
    public static void simulateArrayIndexOutOfBoundsException() {
        try {
            int[] array = new int[5];
            int value = array[10]; // Invalid array index
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught: " + e.getMessage());
        }
    }

    // 9. ClassCastException
    public static void simulateClassCastException() {
        try {
            Object obj = new Integer(100);
            String str = (String) obj; // Invalid type cast
        } catch (ClassCastException e) {
            System.out.println("ClassCastException caught: " + e.getMessage());
        }
    }

    // 10. IllegalArgumentException
    public static void simulateIllegalArgumentException() {
        try {
            Thread.sleep(-100); // Invalid argument
        } catch (IllegalArgumentException | InterruptedException e) {
            System.out.println("IllegalArgumentException caught: " + e.getMessage());
        }
    }

    // 11. NumberFormatException
    public static void simulateNumberFormatException() {
        try {
            int number = Integer.parseInt("invalid_number"); // Invalid number format
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        simulateIOException();
        simulateFileNotFoundException();
        simulateEOFException();
        simulateSQLException();
        simulateClassNotFoundException();
        simulateArithmeticException();
        simulateNullPointerException();
        simulateArrayIndexOutOfBoundsException();
        simulateClassCastException();
        simulateIllegalArgumentException();
        simulateNumberFormatException();
    }
}
