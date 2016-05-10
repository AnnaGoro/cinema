package com.gorobchenkoa.controller;

import com.gorobchenkoa.model.dto.BookDTO;
import com.gorobchenkoa.service.api.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Controller()
public class AdminController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/admin/books", method = RequestMethod.GET)
    public ModelAndView admin(Model model) {

        List<BookDTO> allBooks = bookService.findAllBooks();
        ModelAndView modelAndView = new ModelAndView("admin.jsp");
        modelAndView.addObject("books", allBooks);

        BookDTO bookDTO = new BookDTO();
        model.addAttribute("book", bookDTO);

        return modelAndView;
    }

    @RequestMapping(value = "/admin/deleteBook", method = RequestMethod.POST)
    public ModelAndView deleteBook(@RequestParam("booksIds") Integer[] booksIds, Model model) {

        List<Integer> deletedBooks = bookService.deleteBook(booksIds);


        List<Integer> books = new ArrayList<>(Arrays.asList(booksIds));

        books.removeAll(deletedBooks);

        List<BookDTO> allBooks = bookService.findAllBooks();

        ModelAndView modelAndView = new ModelAndView("admin.jsp");
        modelAndView.addObject("books", allBooks);
        modelAndView.addObject("notDeletedBooks", books);
        BookDTO bookDTO = new BookDTO();
        model.addAttribute("book", bookDTO);
        return modelAndView;
    }

    @RequestMapping(value = "/admin/addBook", method = RequestMethod.POST)
    public ModelAndView deleteBook(@ModelAttribute("book") BookDTO bookDTO, BindingResult result) {

        bookService.createBook(bookDTO);
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/books");
        return modelAndView;
    }

    @RequestMapping(value = "/admin/deleteBook", method = RequestMethod.GET)
    public ModelAndView deleteBookGet(@ModelAttribute("book") @Valid BookDTO bookDTO) {
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/books");
        return modelAndView;
    }
}

