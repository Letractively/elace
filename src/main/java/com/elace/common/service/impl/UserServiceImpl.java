package com.elace.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elace.common.bean.User;
import com.elace.common.dao.UserDao;
import com.elace.common.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	@Override
	public User loadUserByUsername(String username) {
		return userDao.loadUserByUsername( username );
	}

	@Override
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		return userDao.getUserById( id );
	}
	
}
