package edu.brcc.ldh2662.exceptions.lecture;

public class Not42Exception extends Exception {
    public Not42Exception() {
        super("Not 42!");
    }

    public Not42Exception(String s) {
        super(s + "Not 42!");
    }
}
