package com.masai.otms.service;

import com.masai.otms.models.Feedback;

import java.util.List;

public interface FeedbackService {
    String addFeedback(Feedback feedback);
    Feedback findById(Integer id);
    List<Feedback> findByCustomerId(Integer cID);
    List<Feedback> viewAllFeedback();
}
