package com.gorobchenkoa.service.impl;

import com.gorobchenkoa.dao.repository.BookRepository;
import com.gorobchenkoa.model.dto.BookDTO;
import com.gorobchenkoa.model.entity.Movie;
import com.gorobchenkoa.service.helper.AuthorityHelper;
import com.gorobchenkoa.dao.repository.UserRepository;
import com.gorobchenkoa.exceprions.BookAlreadyAppliedException;
import com.gorobchenkoa.exceprions.BookNotFoundException;
import com.gorobchenkoa.model.entity.User;
import com.gorobchenkoa.service.api.BookService;
import com.gorobchenkoa.service.mapper.BasicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kovantonlenko on 12/22/2015.
 */
@Component
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BasicMapper basicMapper;
    @Autowired
    private AuthorityHelper authorityHelper;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;

    public BookDTO findBookById(int id) {
        Movie movieById = bookRepository.findBookById(id);
        BookDTO bookDTO = basicMapper.singleMapper(movieById, BookDTO.class);
        return bookDTO;
    }

    public List<BookDTO> findAllBooks() {
        Iterable<Movie> books = bookRepository.findAll();
        List<BookDTO> bookDTOs = basicMapper.listMapToList(books, BookDTO.class);
        return bookDTOs;
    }

    @Override
    public void applyBookToUser(Integer book_id) {
        Movie movieById = bookRepository.findBookById(book_id);

        if (movieById.getBalance() == 0) {
            throw new BookNotFoundException("Unfortunately limited number of books");
        }

        movieById.setBalance(movieById.getBalance() - 1);
        Integer id = authorityHelper.fetchAuthorizedUserID();
        User userByLogin = userRepository.findUserById(id);

        for (Movie movie : userByLogin.getMovies()) {
            if (movie.getId() == book_id) {
                throw new BookAlreadyAppliedException("You already have this movie");
            }
        }

        userByLogin.getMovies().add(movieById);
        userRepository.save(userByLogin);
    }

    @Override
    public void createBook(BookDTO bookDTO) {
        bookDTO.setStartNumber(bookDTO.getBalance());
        Movie movie = basicMapper.singleMapper(bookDTO, Movie.class);
        bookRepository.save(movie);
    }

    @Override
    public List<Integer> deleteBook(Integer[] booksIds) {
        List<Integer> deletedBooks = new ArrayList<>();
        for (Integer booksId : booksIds) {
            Movie movieById = bookRepository.findBookById(booksId);
            if (movieById.getStartNumber() == movieById.getBalance()) {
                bookRepository.delete(booksId);
                deletedBooks.add(booksId);
            }
        }
        return deletedBooks;
    }


}
