package com.masai.otms.service.Implementations;

import com.masai.otms.exceptions.ReportException;
import com.masai.otms.models.Report;
import com.masai.otms.repository.ReportRepo;
import com.masai.otms.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    ReportRepo rRepo;
    @Override
    public Report addReport(Report r) {
        return rRepo.save(r);
    }

    @Override
    public String deleteReport(Integer id) {
        Report r = rRepo.findById(id).orElseThrow(() -> new ReportException("Incorrect Report Id"));
        rRepo.delete(r);
        return "Report has been deleted";
    }

    @Override
    public Report viewReport(Integer id) {
        return rRepo.findById(id).orElseThrow(() -> new ReportException("Incorrect Report Id"));
    }

    @Override
    public List<Report> viewAll() {
        return rRepo.findAll();
    }
}
