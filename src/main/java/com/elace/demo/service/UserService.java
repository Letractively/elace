package com.elace.demo.service;

import com.elace.demo.model.User;

public interface UserService {
	/**
	 * Provied :
	 * 		Retrieve the user with its id
	 * @param id
	 * 		the user's id
	 * @return
	 * 		the corresponding User
	 */
	public User getUserById( Long id );
}
