package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.DonorDTO;
import com.app.service.DonorService;

@RestController
@RequestMapping("/donors")
@CrossOrigin(origins = "http://localhost:3000")
public class DonorController {

	@Autowired
	private DonorService donorService;
	
	@PostMapping
	public ResponseEntity<?> addNewDonor(@RequestBody DonorDTO dto)
	{
		
		return ResponseEntity.status(HttpStatus.CREATED).body(donorService.addNewDonor(dto));
	}
	
	@GetMapping("/{donorid}")
	public ResponseEntity<?> getDonorDetails(@PathVariable Long donorid){
		
		return ResponseEntity.ok(donorService.getDonorDetails(donorid));
		
	}
	
	@PutMapping("/{donorid}")
	public ResponseEntity<?> updateDonor(@PathVariable Long donorid,@RequestBody  DonorDTO donor)
	{
		return ResponseEntity.ok(donorService.updateUser(donorid,donor));
	}
	
	@GetMapping
	public ResponseEntity<?> getAllDonorDetails() {
		
		return ResponseEntity
				.ok(donorService.getAllUser());
	}
}
