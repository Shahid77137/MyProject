package com.masai.otms.controller;

import com.masai.otms.exceptions.TicketDetailsException;
import com.masai.otms.models.TicketDetails;
import com.masai.otms.repository.TicketDetailsRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketDetailsRepo ticketDetailsRepo;

    @PostMapping("/new")
    public ResponseEntity<TicketDetails> createTicket(@Valid @RequestBody TicketDetails td) {
        return ResponseEntity.ok(ticketDetailsRepo.save(td));
    }

    @DeleteMapping("remove/ticket/{ticketId}")
    public ResponseEntity<String> removeticket(@PathVariable Integer ticketId) {
        TicketDetails td = ticketDetailsRepo.findById(ticketId).orElseThrow(() -> new TicketDetailsException("Invalid ticket id"));
        ticketDetailsRepo.delete(td);
        return ResponseEntity.ok("Ticket has been cancelled");
    }
}
