package com.gorobchenkoa.exceprions;

/**
 * Created by Kovantonlenko on 12/28/2015.
 */
public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(String message) {
        super(message);
    }
}
