package com.gorobchenkoa.service.impl;

import com.gorobchenkoa.model.entity.Report;
import com.gorobchenkoa.service.api.ReportService;
import com.gorobchenkoa.dao.repository.ReportRepository;
import com.gorobchenkoa.model.dto.ReportDTO;
import com.gorobchenkoa.service.mapper.BasicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Kovantonlenko on 12/22/2015.
 */
@Component
@Transactional
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportRepository reportRepository;
    @Autowired
    private BasicMapper basicMapper;

    public List<ReportDTO> findAllReports() {
        List<Report> reports = reportRepository.findAll();
        List<ReportDTO> reportDTOs = basicMapper.listMapToList(reports, ReportDTO.class);
        return reportDTOs;
    }
}
