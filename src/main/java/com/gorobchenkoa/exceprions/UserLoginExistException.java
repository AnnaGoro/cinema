package com.gorobchenkoa.exceprions;

/**
 * Created by Kovantonlenko on 12/27/2015.
 */
public class UserLoginExistException extends UserAuthException {

    public UserLoginExistException(String message) {
        super(message);
    }
}
