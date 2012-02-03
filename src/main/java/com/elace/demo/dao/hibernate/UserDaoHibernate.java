package com.elace.demo.dao.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.elace.common.db.dao.GenericDaoHibernate;
import com.elace.demo.dao.UserDao;
import com.elace.demo.model.User;

public class UserDaoHibernate extends GenericDaoHibernate<User, Long> implements UserDao{
	
	@Autowired
	public UserDaoHibernate( SessionFactory sessionFactory ) {
		super(sessionFactory, User.class);
	}
	
	@Override
	public User getUserByUserId( Long userId ) {
		return get( userId );
	}

}
