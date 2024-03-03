package com.app.service;

import java.util.List;

import com.app.dto.DonorDTO;

public interface DonorService  {

	DonorDTO addNewDonor(DonorDTO dto);

	DonorDTO getDonorDetails(Long donorid);

	DonorDTO updateUser(Long donorid, DonorDTO donor);

	List<DonorDTO> getAllUser();

}
