package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.PetDTO;
import com.app.service.PetsService;

@RestController
@RequestMapping("/pets")
@CrossOrigin(origins = "http://localhost:3000")
public class PetsController {
	@Autowired
	private PetsService petService;
	
	@PostMapping
	public ResponseEntity<?> addNewPet(@RequestBody  PetDTO dto) {
		System.out.println("in add emp " + dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(petService.addNewPet(dto));
	}
	
	
	@PutMapping("/{petId}")
	public ResponseEntity<?> updateEmployee(@PathVariable Long petId, @RequestBody  PetDTO dto) {
		System.out.println("in update emp " +petId + " " + dto);
		return ResponseEntity.ok(petService.updateEmployee(petId, dto));
	}
	
	@GetMapping("/{petId}")
	public ResponseEntity<?> getPetDetails(@PathVariable Long petId) {
		
		return ResponseEntity
				.ok(petService.getPetDetails(petId));
	}
	
	@DeleteMapping("/{petId}")
	public ResponseEntity<?> deleteEmployee(@PathVariable Long petId) {
		
		return ResponseEntity.ok(petService.deleteEmpDetails(petId));
	}
	
//	@GetMapping
//	public ResponseEntity<?> getAllPetDetails() {
//		
//		return ResponseEntity
//				.ok(petService.getAllPet());
//	}
}
