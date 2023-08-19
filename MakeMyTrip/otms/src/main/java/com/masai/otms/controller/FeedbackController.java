package com.masai.otms.controller;

import com.masai.otms.models.Feedback;
import com.masai.otms.service.FeedbackService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    FeedbackService feedbackService;
    @PostMapping("/add-feedback")
    public ResponseEntity<String> addFeedback(@RequestBody @Valid Feedback feedback) {
        return ResponseEntity.ok(feedbackService.addFeedback(feedback));
    }

    @GetMapping("/by-id/{id}")
    public ResponseEntity<Feedback> findById(@Valid @PathVariable Integer id) {
        return ResponseEntity.ok(feedbackService.findById(id));
    }

    @GetMapping("/all-feedbacks/{id}")
    public ResponseEntity<List<Feedback>> findFeedbackOfCustomer(@Valid @PathVariable Integer id) {
        return ResponseEntity.ok(feedbackService.findByCustomerId(id));
    }

    @GetMapping("/feedbacks")
    public ResponseEntity<List<Feedback>> allFeedbacks() {
        return ResponseEntity.ok(feedbackService.viewAllFeedback());
    }
}
