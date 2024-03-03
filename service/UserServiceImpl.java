package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ApiException;
import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.UserDao;
import com.app.dto.PetUsersDTO;
import com.app.dto.UserDTO;
import com.app.entities.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userdao;
	@Autowired
	private ModelMapper mapper;
	@Override
	public UserDTO addNewUser( UserDTO dto) {
		if(dto.getPassword().equals(dto.getConfirmPassword()))
		{
		User userEntity=mapper.map(dto,User.class);
		User user1=userdao.save(userEntity);
		return mapper.map(user1, UserDTO.class);
		}
		throw new ApiException("Password doesnt match");
	}
	
	
	@Override
	public UserDTO getUserDetails(Long userid) {
		
		return mapper.map(userdao.findById(userid)
				.orElseThrow(()->new ResourceNotFoundException("Invalid UserID!!")),
				UserDTO.class);
	}


	@Override
	public UserDTO updateUser(Long userid, UserDTO user) {
		User u=userdao.findById(userid)
				.orElseThrow(()->new ResourceNotFoundException("Invalid UserID!!"));
		u.setName(user.getName());
		u.setEmail(user.getEmail());
		u.setPassword(user.getPassword());
		u.setDate(user.getDate());
		u.setType(user.getType());
		return mapper.map(u, UserDTO.class);
	}


	@Override
	public List<UserDTO> getAllUser() {
		return userdao.findAll() // List<Department>
				.stream() // Stream<Department>
				.map(dept -> mapper.map(dept, UserDTO.class)) // Stream<
				.collect(Collectors.toList());
		
	}


	
	
	

}
