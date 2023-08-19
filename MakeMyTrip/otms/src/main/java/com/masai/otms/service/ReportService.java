package com.masai.otms.service;

import com.masai.otms.models.Report;

import java.util.List;

public interface ReportService {
    Report addReport(Report r);
    String deleteReport(Integer id);
    Report viewReport(Integer id);
    List<Report> viewAll();
}
