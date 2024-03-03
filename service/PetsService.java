package com.app.service;

import javax.validation.Valid;

import com.app.dto.PetDTO;
import com.app.dto.PetsDTO;

public interface PetsService {

	PetsDTO addNewPet(@Valid PetDTO dto);

	PetDTO updateEmployee(Long petId,  PetDTO dto);

	PetDTO getPetDetails(Long petId);

	String deleteEmpDetails(Long petId);

	//List<PetDTO> getAllPet();

}
