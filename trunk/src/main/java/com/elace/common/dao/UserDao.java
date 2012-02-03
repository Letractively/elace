package com.elace.common.dao;

import com.elace.common.bean.User;

public interface UserDao {
	
	User loadUserByUsername( String username );
	
	User getUserById(Long id);
}
