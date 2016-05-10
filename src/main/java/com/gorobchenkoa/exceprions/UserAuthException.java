package com.gorobchenkoa.exceprions;

/**
 * Created by Kovantonlenko on 12/29/2015.
 */
public class UserAuthException extends RuntimeException{
    public UserAuthException(String message) {
        super(message);
    }
}
