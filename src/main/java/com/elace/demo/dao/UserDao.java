package com.elace.demo.dao;

import org.springframework.transaction.annotation.Transactional;

import com.elace.demo.model.User;

public interface UserDao {
	
	/**
	 * Get A specified User instance by its id
	 * @param userId	the user's id
	 * @return
	 * 		the coressponding user to the id;
	 */
	public User getUserByUserId( Long userId );
}
