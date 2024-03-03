package com.app.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.app.dto.PetUsersDTO;
import com.app.dto.UserDTO;


public interface UserService {

	UserDTO addNewUser(@Valid UserDTO dto);

	UserDTO getUserDetails(Long userid);

	UserDTO updateUser(Long userid, @Valid UserDTO user);

	List<UserDTO> getAllUser();

	
	
}
