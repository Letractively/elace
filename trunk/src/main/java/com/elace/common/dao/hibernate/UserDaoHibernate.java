package com.elace.common.dao.hibernate;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.elace.common.bean.User;
import com.elace.common.dao.UserDao;
import com.elace.common.db.dao.GenericDaoHibernate;

@Repository
public class UserDaoHibernate extends GenericDaoHibernate<User, Long> implements UserDao {
	
	@Autowired
	public UserDaoHibernate( SessionFactory sessionFactory ) {
		super( sessionFactory, User.class );
	}

	public User loadUserByUsername( String username ){
		return get( 814L );
	}

	@Override
	public User getUserById(Long id) {
		return get( 814L );
	}
 }
