package com.app.controller;

import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AddressDTO;
import com.app.service.AddressService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/users/{userId}/address")
@Validated //needed for validations of path var n req params
public class AddressController {
	@Autowired
	private AddressService adrService;

	public AddressController() {
		System.out.println("in ctor of " + getClass());
	}

	
	@PostMapping
	@Operation
	public ResponseEntity<?> assignEmpAddress(@PathVariable @NotNull Long userId,
			@RequestBody @Valid AddressDTO address) {
		System.out.println("in assign adr " + userId + " " + address);
		return ResponseEntity.status(HttpStatus.CREATED).body(adrService.assignEmpAddress(userId, address));
	}

	
	@GetMapping
	@Operation
	public ResponseEntity<?> getEmpAddress(@PathVariable Long userId) {
		
		return ResponseEntity.ok(adrService.getAddressDetails(userId));
	}

	
	@PutMapping
	@Operation
	public ResponseEntity<?> updateEmpAddress(@PathVariable @NotNull Long petId,
			@RequestBody @Valid AddressDTO address) {
		System.out.println("in complete update adr " + petId + " " + address);
		return ResponseEntity.ok()
				.body(adrService.updateEmpAddress(petId, address));
	}

	
	@PatchMapping
	@Operation
	public ResponseEntity<?> updateEmpAddressPartial(@PathVariable @NotNull Long petId,
			@RequestBody Map<String, Object> map) throws Exception{
		System.out.println("in partial update adr " + petId + " " + map);
		return ResponseEntity.ok()
				.body(adrService.patchEmpAddress(petId, map));
	}
}
