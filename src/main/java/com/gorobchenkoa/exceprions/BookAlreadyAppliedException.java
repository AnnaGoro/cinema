package com.gorobchenkoa.exceprions;

/**
 * Created by Kovantonlenko on 12/28/2015.
 */
public class BookAlreadyAppliedException extends RuntimeException {

    public BookAlreadyAppliedException(String message) {
        super(message);
    }
}
