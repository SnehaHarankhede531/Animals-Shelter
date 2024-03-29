package com.app.service;

import java.util.Map;

import javax.validation.Valid;

import com.app.dto.AddressDTO;
import com.app.dto.ApiResponse;

public interface AddressService {	
	// assign emp address
		ApiResponse assignEmpAddress( Long petId, @Valid AddressDTO address);		
//get address details
	AddressDTO getAddressDetails(Long addressId);
	//update emp address : complete update
	ApiResponse updateEmpAddress( Long petId, @Valid AddressDTO address);
	//update emp address : partial update
	AddressDTO patchEmpAddress( Long petId, Map<String, Object> map);
}
