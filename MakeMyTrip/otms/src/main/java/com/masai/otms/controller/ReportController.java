package com.masai.otms.controller;

import com.masai.otms.models.Report;
import com.masai.otms.service.ReportService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ReportController {
    @Autowired
    ReportService rServ;

    @PostMapping("/add-report")
    public ResponseEntity<Report> addReport(@Valid @RequestBody Report r) {
        return ResponseEntity.ok(rServ.addReport(r));
    }

    @DeleteMapping("/remove/report/{id}")
    public ResponseEntity<String> deleteReport(@Valid @PathVariable Integer id) {
        return ResponseEntity.ok(rServ.deleteReport(id));
    }
    @GetMapping("/report/search/{id}")
    public ResponseEntity<Report> viewReport(@Valid @PathVariable Integer id) {
        return ResponseEntity.ok(rServ.viewReport(id));
    }

    @GetMapping("/report/all")
    public ResponseEntity<List<Report>> viewAll() {
        return ResponseEntity.ok(rServ.viewAll());
    }
}
