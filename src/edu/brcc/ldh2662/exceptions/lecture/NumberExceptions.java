package edu.brcc.ldh2662.exceptions.lecture;

import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * better exception handling than FileExceptionHandle class
 *1/17/2018
 * @author Lucas Helms
 */
public class NumberExceptions {
    private Scanner userIn;
    private PrintWriter userOut;
    private final int MIN = 1;
    private final int MAX = 10;

    public NumberExceptions() {
    }

    public NumberExceptions(InputStream inputStream, PrintStream printStream) {
        int number = 0;
        int userTries = 3;
        userIn = new Scanner(inputStream);
        userOut = new PrintWriter(printStream, true);

        while ((number < MIN || number > MAX) && userTries-- > 0) {
            userOut.println("Please enter a number between " + MIN
                    + " and " + MAX + ".");
            try {
                number = userIn.nextInt();
            }
            catch (InputMismatchException e) {
                userOut.println("Please enter an integer value.");
                userIn.nextLine();
            }
        }
        userOut.println(number + " is good.");
        userIn.close();
        userOut.close();
    }

    public static void main(String[] args) {
        new NumberExceptions(System.in, System.out);
    }
}
