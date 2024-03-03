package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.DonorDao;
import com.app.dto.DonorDTO;
import com.app.entities.Donor;

@Service
@Transactional
public class DonorServiceImpl implements DonorService {
	
	@Autowired
	private DonorDao donordao;
	@Autowired
	private ModelMapper mapper;
	@Override
	public DonorDTO addNewDonor(DonorDTO dto) {
		Donor donorEntity=mapper.map(dto,Donor.class);
		Donor donor1=donordao.save(donorEntity);
		return mapper.map(donor1, DonorDTO.class);

	}
	@Override
	public DonorDTO getDonorDetails(Long donorid) {
		return mapper.map(donordao.findById(donorid)
				.orElseThrow(()->new ResourceNotFoundException("Invalid UserID!!")),
				DonorDTO.class);
	}
	@Override
	public DonorDTO updateUser(Long donorid, DonorDTO donor) {
		Donor d=donordao.findById(donorid)
				.orElseThrow(()->new ResourceNotFoundException("Invalid UserID!!"));
		d.setName(donor.getName());
		d.setEmail(donor.getEmail());
		d.setMobileNumber(donor.getMobileNumber());
		d.setAddress(donor.getAddress());
		return mapper.map(d, DonorDTO.class);
		
	}
	@Override
	public List<DonorDTO> getAllUser() {
		return donordao.findAll() // List<Department>
				.stream() // Stream<Department>
				.map(donor -> mapper.map(donor, DonorDTO.class)) // Stream<
				.collect(Collectors.toList());
		
	}

}
