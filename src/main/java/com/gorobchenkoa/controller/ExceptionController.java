package com.gorobchenkoa.controller;

import com.gorobchenkoa.exceprions.BookAlreadyAppliedException;
import com.gorobchenkoa.exceprions.BookNotFoundException;
import com.gorobchenkoa.exceprions.UserExistException;
import com.gorobchenkoa.exceprions.UserLoginExistException;
import com.gorobchenkoa.model.dto.UserDTO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kovantonlenko on 12/26/2015.
 */
@ControllerAdvice
public class ExceptionController {

    private static Map<Class, String> exceptions = new HashMap<Class, String>();

    @PostConstruct
    public void init() {
        exceptions.put(UserLoginExistException.class, UserLoginExistException.class.toString());
        exceptions.put(UserExistException.class, UserExistException.class.toString());
        exceptions.put(BookNotFoundException.class, BookNotFoundException.class.toString());
        exceptions.put(BookAlreadyAppliedException.class, BookAlreadyAppliedException.class.toString());
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleAllException(Exception exception) {
        ModelAndView model = null;
        String ex = exceptions.get(exception.getClass());
        if (UserLoginExistException.class.toString().equals(ex) || UserExistException.class.toString().equals(ex)) {
            UserDTO userDTO = new UserDTO();
            model = new ModelAndView("registration.jsp");
            model.addObject("user", userDTO);
            model.addObject("errMsg", exception.getMessage());
        } else if (BookNotFoundException.class.toString().equals(ex)) {
            model = new ModelAndView("redirect:/library/home");
            model.addObject("errMsg", exception.getMessage());
        } else if (BookAlreadyAppliedException.class.toString().equals(ex)) {
            model = new ModelAndView("redirect:/library/home");
            model.addObject("errMsg", exception.getMessage());
        } else {
            model = new ModelAndView("error.jsp");
            model.addObject("errMsg", exception.getMessage());
        }

        return model;
    }
}
