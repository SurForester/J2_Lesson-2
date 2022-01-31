package com.geekbrains.exceptions;

public class MyArraySizeException extends RuntimeException {
    public MyArraySizeException(String s) {
        System.out.println(s);
    }
}
