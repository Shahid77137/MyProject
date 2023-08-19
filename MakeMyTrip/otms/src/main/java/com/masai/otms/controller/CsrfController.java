package com.masai.otms.controller;

//import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/token")
public class CsrfController {
//    @GetMapping(value = "/csrf" , produces = "application/json")
//    public CsrfToken csrf(CsrfToken token) {
//        return token;
//    }
}
