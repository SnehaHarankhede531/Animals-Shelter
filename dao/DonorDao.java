package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Donor;

public interface DonorDao extends JpaRepository<Donor, Long> {

}
