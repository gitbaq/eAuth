/**
 * 
 */
package com.syedbaqirali.EnterpriseAuth.auth.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.syedbaqirali.EnterpriseAuth.auth.User;
import com.syedbaqirali.EnterpriseAuth.auth.UserRepository;

/**
 * @author rever
 *
 */
@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByUserName(username);

		user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));

		return user.map(MyUserDetails::new).get();
	}

}
