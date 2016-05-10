package com.gorobchenkoa.controller;

import com.gorobchenkoa.model.dto.UserDTO;
import com.gorobchenkoa.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by Kovantonlenko on 12/25/2015.
 */
@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDTO userDto = new UserDTO();
        model.addAttribute("user", userDto);
        return "registration.jsp";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registerUserAccount(@ModelAttribute("user") @Valid UserDTO accountDto,
                                            BindingResult result) {

        ModelAndView modelAndView = null;

        if (!result.hasErrors()) {
            createUserAccount(accountDto);
            modelAndView = new ModelAndView("redirect:/library/home", "user", accountDto);
        } else {
            modelAndView = new ModelAndView("registration.jsp", "user", accountDto);
        }
        return modelAndView;
    }

    private UserDTO createUserAccount(UserDTO accountDto) {
        UserDTO user = userService.createUser(accountDto);
        return user;
    }

/*
    @ExceptionHandler(UserAuthException.class)
    public ModelAndView userAuthException(HttpServletRequest request, Exception ex) {
        UserDTO userDTO = new UserDTO();
        ModelAndView model = new ModelAndView("registration.jsp");
        model.addObject("user", userDTO);
        model.addObject("errMsg", ex.getMessage());
        return model;
    }
*/

}
