package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	
	public Employee findByMobileNo(String mobileNo);
	
	public Employee findByempName(String empName);
	
	public List<Employee>  findBydpartment_dpname(String dpName);
	
}
