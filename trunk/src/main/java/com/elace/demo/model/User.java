package com.elace.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

@Entity
@Table(name="auth_user")
public class User {
	@Id
	@GeneratedValue( strategy=GenerationType.IDENTITY)
	private Long id;
	//Username of user;
	private String username;
	//Email of user;
	private String email;
	
	public Long getId(){
		return id;
	}
	
	public String getUsername(){
		return username;
	}
	
	public String getEmail(){
		return email;
	}
	
}
