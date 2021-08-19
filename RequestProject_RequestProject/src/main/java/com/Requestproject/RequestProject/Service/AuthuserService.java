package com.Requestproject.RequestProject.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Requestproject.RequestProject.Domain.Systemuser;
import com.Requestproject.RequestProject.Domain.Userprincipal;
import com.Requestproject.RequestProject.Repository.SystemuserRepository;

@Service
public class AuthuserService implements UserDetailsService{

	 @Autowired
	 private SystemuserRepository userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		/*
		 * Optional<Systemuser> optionalUser = userDao.findByUuid(username); if
		 * (optionalUser.isPresent()) { return optionalUser.get(); } else { throw new
		 * UsernameNotFoundException("Incorrect credentials"); }
		 */
		Systemuser systemuser = userDao.findByUsername(username);
		if(systemuser==null) 
			throw new UsernameNotFoundException("User 404");
		
			return  systemuser;
		
		
	}

}
