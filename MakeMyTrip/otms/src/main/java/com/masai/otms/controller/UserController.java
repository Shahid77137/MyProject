package com.masai.otms.controller;


import com.masai.otms.models.Customer;
import com.masai.otms.models.Users;
import com.masai.otms.repository.CustomerRepo;
import com.masai.otms.repository.UserRepo;
import com.masai.otms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private CustomerRepo customerRepository;

    @Autowired
    private UserService usersService;

    private UserRepo userRepo;

//    @Autowired
//    private PasswordEncoder passwordEncoder;
	
//	@GetMapping("/signIn")
//	public ResponseEntity<Customer> getLoggedInCustomerDetailsHandler(Authentication auth){
//
//
//		 Customer customer= customerRepository.findByEmail(auth.getName()).orElseThrow(() -> new BadCredentialsException("Invalid Username or password"));
//
//		 return new ResponseEntity<>(customer, HttpStatus.ACCEPTED);
//
//
//	}

    @PostMapping("/users")
    public ResponseEntity<Users> addUsersHandler(@RequestBody Users users){

//        users.setUserPassword(passwordEncoder.encode(users.getUserPassword()));
        Users users1 = usersService.addUser(users);

        return new ResponseEntity<>(users1, HttpStatus.CREATED);
    }

//    @GetMapping("/userSignIn")
//    public ResponseEntity<Users> getLoggedInUserDetailsHandler(Authentication auth){
//
//        Users users= userRepo.findByUserType(auth.getName()).orElseThrow(() -> new BadCredentialsException("Invalid Usertype or password"));
//
//        return new ResponseEntity<>(users, HttpStatus.ACCEPTED);
//
//    }

    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }

}
