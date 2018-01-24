package edu.brcc.ldh2662.exceptions.lecture;

import java.util.zip.DataFormatException;

/**
 *
 */
public class ThrowException {
    public static void main(String[] args) {
        try {
            nastyMethod(14);
        } catch (Not42Exception e) {
            System.out.println(e.getMessage());;
        }
    }

    private static void nastyMethod(int number) throws Not42Exception {
        if (number != 42) {
            throw new Not42Exception("" + number + " ");
        }
    }
}
