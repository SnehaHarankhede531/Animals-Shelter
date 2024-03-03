package com.app.dao;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.User;

public interface UserDao extends JpaRepository<User, Long> {
	
}
