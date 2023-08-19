package com.masai.otms.service.Implementations;


import com.masai.otms.exceptions.CustomerException;
import com.masai.otms.exceptions.FeedbackException;
import com.masai.otms.models.Customer;
import com.masai.otms.models.Feedback;
import com.masai.otms.repository.CustomerRepo;
import com.masai.otms.repository.FeedbackRepo;
import com.masai.otms.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    FeedbackRepo feedbackRepo;

    @Override
    public String addFeedback(Feedback feedback) {
        Feedback f = feedbackRepo.save(feedback);
        return "Feedback has been saved with id: " + f.getFeedbackId();
    }

    @Override
    public Feedback findById(Integer id) {
        return feedbackRepo.findById(id).orElseThrow(() -> new FeedbackException("Invalid Feedback ID provided"));
    }

    @Override
    public List<Feedback> findByCustomerId(Integer cID) {
        Customer customer = customerRepo.findById(cID).orElseThrow(() -> new CustomerException("Invalid Customer Id"));
        return customer.getFeedbacks() == null ? new ArrayList<>() : customer.getFeedbacks();
    }

    @Override
    public List<Feedback> viewAllFeedback() {
        return feedbackRepo.findAll();
    }
}
