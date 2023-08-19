package com.masai.otms.service.Implementations;


import com.masai.otms.models.Customer;
import com.masai.otms.models.Users;
import com.masai.otms.repository.CustomerRepo;
import com.masai.otms.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerUserDetailsService {

//	@Autowired
//	private CustomerRepo customerRepository;
//
//    @Autowired
//    private UserRepo userRepo;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//
//		Optional<Users> opt= userRepo.findByUserType(username);
//
//		if(opt.isPresent()) {
//
//            Users users= opt.get();
//
//			List<GrantedAuthority> authorities= new ArrayList<>();
//			//authorities.add(new SimpleGrantedAuthority(customer.getRole()));
//
//
//			return new User(users.getUserType(), users.getUserPassword(), authorities);
//
//
//
//		}else
//			throw new BadCredentialsException("User Details not found with this username: "+username);
//
//
//
//
//
//	}

}
