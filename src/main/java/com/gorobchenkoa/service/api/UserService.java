package com.gorobchenkoa.service.api;

import com.gorobchenkoa.model.dto.BookDTO;
import com.gorobchenkoa.model.dto.UserDTO;

import java.util.List;

/**
 * Created by Kovantonlenko on 12/22/2015.
 */
public interface UserService {

    UserDTO createUser(UserDTO userDTO);

    UserDTO findUserById(int id);

    void returnBook(Integer[] booksIds);

    List<BookDTO> findUserBooks();
}
