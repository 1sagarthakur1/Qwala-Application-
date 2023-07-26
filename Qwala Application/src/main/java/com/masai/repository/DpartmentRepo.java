package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Dpartment;

@Repository
public interface DpartmentRepo  extends JpaRepository<Dpartment, Integer>{
	
	public Dpartment  findByDpname(String dpname);
	
}
