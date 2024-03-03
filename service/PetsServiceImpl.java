package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.PetsDao;
import com.app.dao.UserDao;
import com.app.dto.PetDTO;
import com.app.dto.PetsDTO;
import com.app.entities.Pets;
import com.app.entities.User;

@Service
@Transactional
public class PetsServiceImpl implements PetsService {
	@Autowired
	private PetsDao petdao;
	
	@Autowired
	private UserDao userdao;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public PetsDTO addNewPet(PetDTO dto) {
		User user = userdao.findById(dto.getUserId())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Dept Id!!!"));
		Pets petEntity = mapper.map(dto, Pets.class);
		user.addPets(petEntity);
		Pets savedPet =petdao.save(petEntity);
		System.out.println("emp entity id " + petEntity.getId() + " " + savedPet.getId());
		return mapper.map(savedPet, PetsDTO.class);	
	}
	

	@Override
	public PetDTO updateEmployee(Long petId, PetDTO dto) {
//
		Pets pet =petdao.findById(petId).
				orElseThrow(() -> new ResourceNotFoundException("Invalid Dept Id !!!!"));
				pet.setAge(pet.getAge());
				pet.setColor(pet.getColor());
				pet.setBreed(pet.getBreed());
				return mapper.map(pet, PetDTO.class);
		
	}

	@Override
	public PetDTO getPetDetails(Long petId) {
		
		Pets pet=petdao.findById(petId).orElseThrow(() -> new ResourceNotFoundException("Invalid Dept Id !!!!"));
		PetDTO p=mapper.map(pet,PetDTO.class);
		p.setUserId(pet.getUser().getId());
		return p;
	}


	@Override
	public String deleteEmpDetails(Long petId) {
		Pets pet = petdao.findById(petId).
				orElseThrow(() -> new ResourceNotFoundException("Invalid emp id"));
		petdao.delete(pet);
		return ("Pet"+" "+petId+" is deleted");
	}


//	@Override
//	public List<PetDTO> getAllPet() {
//	return petdao.findAll() // List<Department>
//				.stream() // Stream<Department>
//				.map(pet -> mapper.map(pet, PetDTO.class)) // Stream<
//				.collect(Collectors.toList());
//	}

}
