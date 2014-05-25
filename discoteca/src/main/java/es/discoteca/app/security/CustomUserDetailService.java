package es.discoteca.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import es.home.almacen.bbdd.service.UserService;

@Component
public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	private UserService service;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		return service.findByUsername(username);
	}

}
