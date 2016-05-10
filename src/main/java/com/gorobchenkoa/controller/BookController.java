package com.gorobchenkoa.controller;

import com.gorobchenkoa.service.api.BookService;
import com.gorobchenkoa.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Kovantonlenko on 12/27/2015.
 */
@Controller
@RequestMapping(value = "/library")
public class BookController {

    private static final String HOME_REDIRECT = "redirect:/library/home";

    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/applyBook", method = RequestMethod.POST)
    public ModelAndView applyBook(@RequestParam(value = "book_id", required = false) Integer book_id) {
        ModelAndView modelAndView = new ModelAndView(HOME_REDIRECT);
        bookService.applyBookToUser(book_id);
        return modelAndView;
    }

    @RequestMapping(value = "/returnBook", method = RequestMethod.POST)
    public ModelAndView returnBook(@RequestParam(value = "booksIds", required = false) Integer[] booksIds) {
        ModelAndView modelAndView = new ModelAndView(HOME_REDIRECT);
        userService.returnBook(booksIds);
        return modelAndView;
    }

   /* @ExceptionHandler(BookNotFoundException.class)
    public ModelAndView bookNotFound(HttpServletRequest request, Exception ex) {
        ModelAndView model = new ModelAndView(HOME_REDIRECT);
        model.addObject("errMsg", ex.getMessage());
        return model;
    }

    @ExceptionHandler(BookAlreadyAppliedException.class)
    public ModelAndView bookAlreadyExist(HttpServletRequest request, Exception ex) {
        ModelAndView model = new ModelAndView(HOME_REDIRECT);
        model.addObject("errMsg", ex.getMessage());
        return model;
    }*/

}
