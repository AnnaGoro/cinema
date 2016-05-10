package com.gorobchenkoa.dao.repository;

import com.gorobchenkoa.model.entity.Report;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Kovantonlenko on 12/22/2015.
 */
public interface ReportRepository extends CrudRepository<Report, Long> {

    List<Report> findAll();

}
