package com.Student.Exceptions;

public class Error  extends Exception{
    private static final long serialVersionUID = 1L;

    public Error (){

    }
    public Error(String message) {
        super(message);
    }
}
