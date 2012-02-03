package com.elace.cas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.elace.common.bean.User;
import com.elace.common.service.UserService;

public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Override
	public UserDetails loadUserByUsername( String username )
			throws UsernameNotFoundException, DataAccessException {
		User user = userService.loadUserByUsername( username );
		user.setAuthorities( getDefaultAuthority() );
		return user;
		
	}
	
	public static List<GrantedAuthority> getDefaultAuthority(){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add( new GrantedAuthorityImpl("ROLE_USER") );
		return authorities;
	}
	@Autowired
	private UserService userService;

}
