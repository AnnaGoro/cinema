package com.gorobchenkoa.exceprions;

/**
 * Created by Kovantonlenko on 12/27/2015.
 */
public class UserExistException extends UserAuthException  {

    public UserExistException(String message) {
        super(message);
    }
}
