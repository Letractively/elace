package com.elace.common.service;

import com.elace.common.bean.User;

public interface UserService {
	/**
	 * Retrieve the user with the given username
	 * @param username	the user's name
	 * @return
	 * 		return the corresponding user
	 */
	User loadUserByUsername( String username );
	
	/**
	 * Retrieve the user with the id
	 * @param id	the user's id
	 * @return
	 * 		return the corresponding user
	 */
	User getUserById( Long id );
}
