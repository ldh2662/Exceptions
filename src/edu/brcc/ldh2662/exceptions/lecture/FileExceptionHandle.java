package edu.brcc.ldh2662.exceptions.lecture;

import java.io.*;
import java.util.Scanner;

public class FileExceptionHandle {
    private Scanner userIn;
    private PrintWriter userOut;

    /**
     * just because you should always have a no-arg constructor
     */
    public FileExceptionHandle() {
    }

    /**
     * do all of the work of the class
     * @param in for user input
     * @param out for user output
     */
    public FileExceptionHandle(InputStream in, PrintStream out) {
        FileInputStream fileInputStream;
        Scanner inFile;
        String line;
        userIn = new Scanner(in);
        userOut = new PrintWriter(out, true);

        try {
            userOut.println("Enter name of file to read:");
            fileInputStream = new FileInputStream(userIn.next());
            inFile = new Scanner(fileInputStream);
            while (inFile.hasNext()) {
                line = inFile.nextLine();
                userOut.println(line);
            }
            fileInputStream.close();
        }
        catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
        userIn.close();
        userOut.close();
    }

    public static void main(String[] args) {
        new FileExceptionHandle(System.in, System.out);
    }
}
