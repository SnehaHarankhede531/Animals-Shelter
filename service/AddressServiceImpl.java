package com.app.service;

import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.AddressDao;
import com.app.dao.UserDao;
import com.app.dto.AddressDTO;
import com.app.dto.ApiResponse;
import com.app.entities.Address;
import com.app.entities.User;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {
	@Autowired
	private UserDao userdao;

	@Autowired
	private AddressDao adrdao;

	@Autowired
	private ModelMapper mapper;	

	@Override
	public AddressDTO getAddressDetails(Long addressId) {
		// TODO Auto-generated method stub
		return mapper.map(
				adrdao.findById(addressId).orElseThrow(
						() -> new ResourceNotFoundException("Invalid Emp  Id Or Address not yet assigned !!!!")),
				AddressDTO.class);
	}

	@Override
	public ApiResponse assignEmpAddress(Long userId, AddressDTO address) {
		// validate emp : can be replaced by getReferenceById : a proxy
		User user = userdao.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Emp ID!!!"));
		// map dtp --> entity
		Address addressEntity = mapper.map(address, Address.class);
		// establish un dir link , adr ---> emp
		addressEntity.setOwner(user);
		// save adr details
		adrdao.save(addressEntity);
		return new ApiResponse( "Assigned new address to Emp , " + user.getName());
	}

	@Override
	public ApiResponse updateEmpAddress(Long userId, AddressDTO address) {
		Address addressEntity = adrdao.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Address is not yet assigned !!!! "));
	
		mapper.map(address, addressEntity);
		// save adr details
		adrdao.save(addressEntity);
		return new ApiResponse("User Addresss updated"+userId);

	}

	@Override
	public AddressDTO patchEmpAddress(Long userId, Map<String, Object> map) {
		// chk if adr exists
		Address address = adrdao.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Address Id!!!!"));
			
		mapper.map(map,address);
		
		System.out.println("updated address " + address);
		return mapper.map(address, AddressDTO.class);
	}

}
