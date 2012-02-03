package com.elace.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.elace.demo.dao.UserDao;
import com.elace.demo.model.User;
import com.elace.demo.service.UserService;

public class UserServiceImpl implements UserService {

	
	private UserDao userDao;
	
	@Override
	public User getUserById(Long id) {
		return userDao.getUserByUserId( id );
	}

}
