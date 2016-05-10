package com.gorobchenkoa.dao.repository;

import com.gorobchenkoa.model.entity.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Kovantonlenko on 12/22/2015.
 */
public interface BookRepository extends CrudRepository<Movie, Integer> {
    Movie findBookById(int id);

    List<Movie> findAllBooksById(@Param("booksIds") List<Integer> booksIds);

}
