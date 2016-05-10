package com.gorobchenkoa.service.impl;

import com.gorobchenkoa.dao.repository.BookRepository;
import com.gorobchenkoa.exceprions.UserLoginExistException;
import com.gorobchenkoa.model.dto.BookDTO;
import com.gorobchenkoa.model.dto.UserDTO;
import com.gorobchenkoa.model.entity.Movie;
import com.gorobchenkoa.model.entity.Role;
import com.gorobchenkoa.model.entity.User;
import com.gorobchenkoa.model.entity.UserRole;
import com.gorobchenkoa.service.api.UserService;
import com.gorobchenkoa.service.helper.AuthorityHelper;
import com.gorobchenkoa.dao.repository.UserRepository;
import com.gorobchenkoa.exceprions.UserExistException;
import com.gorobchenkoa.service.mapper.BasicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Kovantonlenko on 12/22/2015.
 */
@Component
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private BasicMapper basicMapper;
    @Autowired
    private AuthorityHelper authorityHelper;
    @Resource
    private UserRepository userRepository;
    @Resource
    private BookRepository bookRepository;

    public UserDTO createUser(UserDTO userDTO) {
        validateUserExists(userDTO);

        User user = basicMapper.singleMapper(userDTO, User.class);

        user.setIsEnabled(true);
        UserRole userRole = new UserRole();
        userRole.setRole(Role.ROLE_USER);
        userRole.setUser(user);
        user.setUserRole(Arrays.asList(userRole));
        User saveUser = userRepository.save(user);
        UserDTO saveUserDTO = basicMapper.singleMapper(saveUser, UserDTO.class);
        return saveUserDTO;
    }

    private void validateUserExists(UserDTO userDTO) {
        List<User> userByEmailOrLogin = userRepository.
                findUserByLoginOrEmail(userDTO.getLogin(), userDTO.getEmail());

        boolean isEmailExist = false;
        boolean isLoginExist = false;
        for (User user : userByEmailOrLogin) {
            if (user.getEmail().equals(userDTO.getEmail())) {
                isEmailExist = true;
                break;
            }
            if (user.getLogin().equals(userDTO.getLogin())) {
                isLoginExist = true;
            }
        }

        if (isEmailExist) throw new UserExistException("user already registered with email " + userDTO.getEmail());
        if (isLoginExist)
            throw new UserLoginExistException("user with login " + userDTO.getLogin() + " already exists");
    }

    public UserDTO findUserById(int id) {
        User userById = userRepository.findUserById(id);
        List<Movie> movies = userById.getMovies();
        System.out.println(movies);
        UserDTO userDTO = basicMapper.singleMapper(userById, UserDTO.class);
        return userDTO;
    }

    @Override
    public void returnBook(Integer[] booksIds) {
        List<Integer> returnedBooksId = Arrays.asList(booksIds);
        Integer id = authorityHelper.fetchAuthorizedUserID();
        User user = userRepository.findUserById(id);

        List<Movie> allUserMovies = user.getMovies();
        List<Movie> deletedMovies = new ArrayList<>();
        for (Movie userMovie : allUserMovies) {
            if (returnedBooksId.contains(userMovie.getId())) {
                userMovie.setBalance(userMovie.getBalance() + 1);
                deletedMovies.add(userMovie);
            }
        }
        user.getMovies().removeAll(deletedMovies);
        bookRepository.save(user.getMovies());
        userRepository.save(user);
    }

    @Override
    public List<BookDTO> findUserBooks() {
        Integer userId = authorityHelper.fetchAuthorizedUserID();
        User user = userRepository.findUserById(userId);
        List<Movie> movies = user.getMovies();

        List<BookDTO> bookDTOs = basicMapper.listMapToList(movies, BookDTO.class);
        return bookDTOs;
    }
}
