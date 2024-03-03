package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Pets;

public interface PetsDao extends JpaRepository<Pets, Long> {

}
