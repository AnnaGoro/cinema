package com.gorobchenkoa.service.api;

import com.gorobchenkoa.model.dto.BookDTO;

import java.util.List;

/**
 * Created by Kovantonlenko on 12/22/2015.
 */
public interface BookService {

    BookDTO findBookById(int id);

    List<BookDTO> findAllBooks();

    void applyBookToUser(Integer book_id);

    void createBook(BookDTO bookDTO);

    List<Integer> deleteBook(Integer[] booksIds);
}