package com.gorobchenkoa.service.helper;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

/**
 * Created by Kovantonlenko on 12/27/2015.
 */
@Component
public class AuthorityHelper {

    public Integer fetchAuthorizedUserID() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Integer userID = Integer.valueOf(user.getUsername());
        return userID;
    }
}
