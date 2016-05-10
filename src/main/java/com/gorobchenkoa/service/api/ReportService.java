package com.gorobchenkoa.service.api;

import com.gorobchenkoa.model.dto.ReportDTO;

import java.util.List;

/**
 * Created by Kovantonlenko on 12/22/2015.
 */
public interface ReportService {
    List<ReportDTO> findAllReports();
}
