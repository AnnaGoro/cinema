package com.gorobchenkoa.dao.repository;

import com.gorobchenkoa.model.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Kovantonlenko on 12/22/2015.
 */

public interface UserRepository extends CrudRepository<User, Long> {

    User findUserById(int id);

    List<User> findUserByLoginOrEmail(String login, String email);

    User findUserByLogin(String login);

}
