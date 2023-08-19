package com.masai.otms.service.Implementations;


import com.masai.otms.models.Customer;
import com.masai.otms.models.Users;
import com.masai.otms.repository.CustomerRepo;
import com.masai.otms.repository.UserRepo;
import com.masai.otms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private CustomerRepo customerRepository;


    @Autowired
    private UserRepo userRepo;
    @Override
    public Users addUser(Users user) {
        return userRepo.save(user);

    }
	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//
//		Optional<Customer> opt= customerRepository.findByEmail(username);
//
//		if(opt.isPresent()) {
//
//			Customer customer= opt.get();
//
//			List<GrantedAuthority> authorities= new ArrayList<>();
//			//authorities.add(new SimpleGrantedAuthority(customer.getRole()));
//
//
//			return new User(customer.getEmail(), customer.getPassword(), authorities);
//
//
//
//		}else
//			throw new BadCredentialsException("User Details not found with this username: "+username);
//
//	}


}
