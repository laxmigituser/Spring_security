package com.pkg.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.pkg.entities.User;
import com.pkg.repository.UserRepository;
@Component
public class CustomUserDetailService implements UserDetailsService {
@Autowired
private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> user = this.userRepository.findByName(username);
		//System.out.println("PRINTING UN "+user.get().getName());
		//System.out.println("PRINTING PW "+user.get().getPassword());
		CustomUserDetails customUserDetails = new CustomUserDetails(user.get());
		return customUserDetails;
		 
	}

}
