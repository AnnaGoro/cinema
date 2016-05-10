package com.gorobchenkoa.controller;

import com.gorobchenkoa.model.dto.BookDTO;
import com.gorobchenkoa.service.api.BookService;
import com.gorobchenkoa.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Kovantonlenko on 12/25/2015.
 */
@Controller
public class HomeController {
    @Autowired
    private BookService bookService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/library/home")
    public ModelAndView home(@RequestParam(value = "errMsg", required = false) String errMsg) {
        List<BookDTO> allBooks = bookService.findAllBooks();
        List<BookDTO> userBooks = userService.findUserBooks();
        ModelAndView modelAndView = new ModelAndView("home.jsp");
        modelAndView.addObject("errMsg", errMsg);
        modelAndView.addObject("books", allBooks);
        modelAndView.addObject("userBooks", userBooks);
        return modelAndView;
    }
}
